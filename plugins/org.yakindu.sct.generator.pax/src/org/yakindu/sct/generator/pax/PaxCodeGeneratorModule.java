package org.yakindu.sct.generator.pax;

import org.yakindu.sct.generator.core.IExecutionFlowGenerator;
import org.yakindu.sct.generator.core.IGeneratorModule;
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess;
import org.yakindu.sct.generator.pax.types.PaxTypeSystemAccess;
import org.yakindu.sct.model.sexec.naming.INamingService;
import org.yakindu.sct.model.sgen.GeneratorEntry;

import com.google.inject.Binder;

public class PaxCodeGeneratorModule implements IGeneratorModule{

	@Override
	public void configure(GeneratorEntry entry, Binder binder) {
		binder.bind(GeneratorEntry.class).toInstance(entry);
		binder.bind(INamingService.class).to(PaxNamingService.class);
		binder.bind(ICodegenTypeSystemAccess.class).to(PaxTypeSystemAccess.class);
		binder.bind(IExecutionFlowGenerator.class).to(PaxGenerator.class);
		binder.bind(IGenArtifactConfigurations.class).to(DefaultGenArtifactConfigurations.class);
		//bindIGenArtifactConfigurations(entry, binder);
	}
	
	protected void bindIGenArtifactConfigurations(GeneratorEntry entry, Binder binder) {
//		FeatureParameterValue useRelativePathParam = entry.getFeatureParameterValue(FEATURE_INCLUDES,
//				PARAMETER_INCLUDES_USE_RELATIVE_PATHS);
//		boolean useRelativePath = useRelativePathParam != null ? useRelativePathParam.getBooleanValue() : true;
//		if (useRelativePath) {
			
//		} else {
//			binder.bind(IGenArtifactConfigurations.class).to(SimpleGenArtifactConfigurations.class);
//		}
	}
	
}
