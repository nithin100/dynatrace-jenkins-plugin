/**
 * 
 */
package com.nithin.jenkins;

import org.kohsuke.stapler.DataBoundConstructor;

import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.model.FreeStyleProject;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Builder;

/**
 * @author Nithin Reddy Ganji
 *
 */
public class DynatraceBuilder extends Builder {

	private final String environmentId;

	private final String apiToken;

	private final String passToken;

	/*
	 * public DynatraceBuilder() {
	 * 
	 * }
	 */

	@DataBoundConstructor
	public DynatraceBuilder(String environmentId, String apiToken, String passToken) {
		super();
		this.environmentId = environmentId;
		this.apiToken = apiToken;
		this.passToken = passToken;
	}

	public String getEnvironmentId() {
		return environmentId;
	}

	public String getApiToken() {
		return apiToken;
	}

	public String getPassToken() {
		return passToken;
	}

	@Override
	public boolean perform(hudson.model.Build<?, ?> build, hudson.Launcher launcher,
			hudson.model.BuildListener listener) throws InterruptedException, java.io.IOException {
		System.out.println(environmentId + " " + apiToken + " " + passToken);
		return true;
	};

	@Extension
	public static final class DynatracePluginBuildDescriptor extends BuildStepDescriptor<Builder> {

		@Override
		public boolean isApplicable(Class<? extends AbstractProject> arg0) {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public String getDisplayName() {
			return "Configure Dynatarce";
		}

	}

}
