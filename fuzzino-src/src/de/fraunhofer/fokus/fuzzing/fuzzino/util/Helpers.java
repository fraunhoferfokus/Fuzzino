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

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class Helpers {

	private Helpers() {
	}
	
	public static EObject load(InputStream stream, String fileName, ResourceSet resourceSet) {
		if (stream == null)
			return null;
		EObject result = null;

		final Resource modelResource = createResource(URI.createURI(fileName), resourceSet);
		try {
			modelResource.load(stream, Collections.emptyMap());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		if (modelResource.getContents().size() > 0)
			result = modelResource.getContents().get(0);

		return result;
	}
	
	public static Resource createResource(URI modelURI, ResourceSet resourceSet) {
		String fileExtension = modelURI.fileExtension();
		if (fileExtension == null || fileExtension.length() == 0) {
			fileExtension = Resource.Factory.Registry.DEFAULT_EXTENSION;
		}

		// First search the resource set for our resource factory
		Resource.Factory.Registry registry = resourceSet.getResourceFactoryRegistry();
		Object resourceFactory = registry.getExtensionToFactoryMap().get(fileExtension);
		if (resourceFactory == null) {
			// then the global registry
			registry = Resource.Factory.Registry.INSTANCE;
			resourceFactory = registry.getExtensionToFactoryMap().get(fileExtension);
			if (resourceFactory != null) {
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
						.put(fileExtension, resourceFactory);
			} else {
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
						.put(fileExtension, new XMIResourceFactoryImpl());
			}
		}

		return resourceSet.createResource(modelURI);
	}

}
