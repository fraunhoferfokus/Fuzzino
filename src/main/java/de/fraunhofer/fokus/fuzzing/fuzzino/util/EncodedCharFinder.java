//   Copyright 2012-2013 Fraunhofer FOKUS
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.
package de.fraunhofer.fokus.fuzzing.fuzzino.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EncodedCharFinder implements List<EncodedCharFinder.EncodedCharPosition> {
	
	protected String str;
	protected List<EncodedCharPosition> foundEntities;

	public class EncodedCharPosition {
		
		private int startIndex;
		private int endIndex;
		
		public EncodedCharPosition(int startIndex, int endIndex) {
			this.startIndex = startIndex;
			this.endIndex = endIndex;
		}
		
		public int getStartIndex() {
			return startIndex;
		}
		
		public int getEndIndex() {
			return endIndex;
		}
		
		public String getEncodedCharString() {
			return EncodedCharFinder.this.str.substring(startIndex, endIndex+1);
		}
		
		@Override
		public String toString() {
			return "[" + getClass().getSimpleName() + " startIndex:" + startIndex + " endIndex:" + endIndex + "]";
		}
	}
	
	public EncodedCharFinder(String str) {
		this.str = str;
		foundEntities = new ArrayList<>();
	}
	
	public void find() {
		Pattern pattern = Pattern.compile("\\\\x([0-9a-f]{2,8}?)");
		Matcher matcher = pattern.matcher(str);
		
		while (matcher.find()) {
			int start = matcher.start();
			int end = matcher.end()-1;
			foundEntities.add(new EncodedCharPosition(start, end));
		}
	}

	@Override
	public int size() {
		return foundEntities.size();
	}

	@Override
	public boolean isEmpty() {
		return foundEntities.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return foundEntities.contains(o);
	}

	@Override
	public Iterator<EncodedCharPosition> iterator() {
		return foundEntities.iterator();
	}

	@Override
	public Object[] toArray() {
		return foundEntities.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return foundEntities.toArray(a);
	}

	@Override
	public boolean add(EncodedCharPosition e) {
		return foundEntities.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return foundEntities.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return foundEntities.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends EncodedCharPosition> c) {
		return foundEntities.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends EncodedCharPosition> c) {
		return foundEntities.addAll(index, c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return foundEntities.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return foundEntities.retainAll(c);
	}

	@Override
	public void clear() {
		foundEntities.clear();
	}

	@Override
	public boolean equals(Object o) {
		return foundEntities.equals(o);
	}

	@Override
	public int hashCode() {
		return foundEntities.hashCode();
	}

	@Override
	public EncodedCharPosition get(int index) {
		return foundEntities.get(index);
	}

	@Override
	public EncodedCharPosition set(int index, EncodedCharPosition element) {
		return foundEntities.set(index, element);
	}

	@Override
	public void add(int index, EncodedCharPosition element) {
		foundEntities.add(index, element);
	}

	@Override
	public EncodedCharPosition remove(int index) {
		return foundEntities.remove(index);
	}

	@Override
	public int indexOf(Object o) {
		return foundEntities.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return foundEntities.lastIndexOf(o);
	}

	@Override
	public ListIterator<EncodedCharPosition> listIterator() {
		return foundEntities.listIterator();
	}

	@Override
	public ListIterator<EncodedCharPosition> listIterator(int index) {
		return foundEntities.listIterator(index);
	}

	@Override
	public List<EncodedCharPosition> subList(int fromIndex, int toIndex) {
		return foundEntities.subList(fromIndex, toIndex);
	}

	
}
