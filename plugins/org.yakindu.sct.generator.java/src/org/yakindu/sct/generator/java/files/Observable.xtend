/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.java.files

import com.google.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.sct.generator.core.library.ICoreLibraryHelper
import org.yakindu.sct.generator.java.GenmodelEntries
import org.yakindu.sct.generator.java.Naming
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.generator.java.features.OutEventObservables

class Observable {
	
	@Inject extension GenmodelEntries
	@Inject extension OutEventObservables
	@Inject extension Naming
	@Inject extension OutputConfigProvider
	@Inject extension ICoreLibraryHelper
	
	def generateObservable(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		if (entry.skipLibraryFiles) {
			return
		}
		val fileName = rxPackagePath + '/' + observableClass.java
		fsa.generateFile(fileName, entry.libraryOutputConfig, entry.content)
	}
	
	def private content(GeneratorEntry entry)
	'''
		«entry.licenseText»
		package «rxPackage»;
		
		import java.util.ArrayList;
		import java.util.List;
		
		public class Observable<T> {
		
			private List<Observer<T>> observers = new ArrayList<>();
		
			public void next(T value) {
				for (Observer<T> observer : observers) {
					observer.next(value);
				}
			}
		
			public boolean subscribe(Observer<T> observer) {
				return observer != null ? this.observers.add(observer) : false;
			}
		
			public boolean unsubscribe(Observer<T> observer) {
				return observer != null ? this.observers.remove(observer) : false;
			}
		}
	'''
	
}