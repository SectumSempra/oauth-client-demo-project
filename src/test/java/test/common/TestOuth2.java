package test.common;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
@Ignore
public class TestOuth2 extends JUnitConfig {

	@Test
	public void getOauth2Token() {
		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
		resourceDetails.setUsername("b");
		resourceDetails.setPassword("b");
		resourceDetails.setAccessTokenUri("http://localhost:18085/oauth/token");
		resourceDetails.setClientId("demo");
		resourceDetails.setClientSecret("demo");
		resourceDetails.setGrantType("password");
		resourceDetails.setScope(Arrays.asList(new String[] { "demoScope" }));
		DefaultOAuth2ClientContext clientContext = new DefaultOAuth2ClientContext();
		OAuth2RestTemplate restTemplate = new OAuth2RestTemplate((OAuth2ProtectedResourceDetails) resourceDetails,
				(OAuth2ClientContext) clientContext);
		String token = restTemplate.getAccessToken().getValue();
		Assert.assertNotNull(token);

		System.err.println(token);
	}
	
	
	@Test
	public void getOauth2Token2() {
		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
		resourceDetails.setUsername("b");
		resourceDetails.setPassword("b");
		resourceDetails.setAccessTokenUri("http://localhost:18085/oauth/token");
		resourceDetails.setClientId("demo");
		resourceDetails.setClientSecret("demo");
		resourceDetails.setGrantType("password");
		resourceDetails.setScope(Arrays.asList(new String[] { "demoScope" }));
		DefaultOAuth2ClientContext clientContext = new DefaultOAuth2ClientContext();
		OAuth2RestTemplate restTemplate = new OAuth2RestTemplate((OAuth2ProtectedResourceDetails) resourceDetails,
				(OAuth2ClientContext) clientContext);
		String token = restTemplate.getAccessToken().getValue();
		Assert.assertNotNull(token);

		System.err.println(token);
	}

}
