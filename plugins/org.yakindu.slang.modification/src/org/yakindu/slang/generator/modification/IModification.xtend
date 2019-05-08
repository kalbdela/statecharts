/** 
 * Copyright (c) 2019 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.slang.generator.modification

import java.util.Collection
import org.yakindu.base.types.Package

/** 
 * @author andreas muelder - Initial contribution and API
 */
interface IModification {

	def Collection<Package> modify(Collection<Package> p)

}
