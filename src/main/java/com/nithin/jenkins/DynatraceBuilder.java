/**
 * 
 */
package com.nithin.jenkins;

import java.io.IOException;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.QueryParameter;

import hudson.Extension;
import hudson.FilePath;
import hudson.Launcher;
import hudson.model.AbstractProject;
import hudson.model.Run;
import hudson.model.TaskListener;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Builder;
import hudson.util.FormValidation;
import jenkins.tasks.SimpleBuildStep;

/**
 * @author Nithin Reddy Ganji
 *
 */
public class DynatraceBuilder extends Builder implements SimpleBuildStep {

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

	/*
	 * @Override public boolean perform(hudson.model.Build<?, ?> build,
	 * hudson.Launcher launcher, hudson.model.BuildListener listener) throws
	 * InterruptedException, java.io.IOException {
	 * System.out.println(environmentId + " " + apiToken + " " + passToken);
	 * return true; };
	 */

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

		public FormValidation doTestConnection(@QueryParameter("environmentId") String environmentId,
				@QueryParameter("apiToken") String apiToken) {
			System.out.println("Passed envId is " + environmentId + " and api token is " + apiToken);
			TestConnection connectionTest = new TestConnection();
			try {
				boolean areValidCredentials = connectionTest.run(environmentId, apiToken);
				if (areValidCredentials) {
					return FormValidation.ok("Test connection successful");
				}
			} catch (IOException e) {
				e.printStackTrace();
				return FormValidation.error("Test connection unsuccessful");
			}
			return FormValidation.error("Test connection unsuccessful");
		}

	}

	@Override
	public void perform(Run<?, ?> arg0, FilePath arg1, Launcher arg2, TaskListener arg3)
			throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.out.println(environmentId + " " + apiToken + " " + passToken);
	}

}
