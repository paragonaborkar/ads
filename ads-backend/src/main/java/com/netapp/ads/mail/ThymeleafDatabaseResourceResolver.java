package com.netapp.ads.mail;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.IEngineConfiguration;
import org.thymeleaf.templateresolver.StringTemplateResolver;
import org.thymeleaf.templateresource.ITemplateResource;

import com.google.common.collect.Sets;
import com.netapp.ads.models.EmailTemplate;
import com.netapp.ads.repos.EmailTemplateRepository;

@Service
public class ThymeleafDatabaseResourceResolver extends StringTemplateResolver {
	
	@Autowired
	EmailTemplateRepository emailTemplateRepository;

	public ThymeleafDatabaseResourceResolver() {
		setResolvablePatterns(Sets.newHashSet("*"));
	}

	@Override
	protected ITemplateResource computeTemplateResource(IEngineConfiguration configuration, String ownerTemplate,
			String template, Map<String, Object> templateResolutionAttributes) {
		EmailTemplate emailTemplate = emailTemplateRepository.findOneByTemplateName(template);
		String thymeleafTemplate = null;
        try {
            thymeleafTemplate = FileUtils.readFileToString(new File(emailTemplate.getTemplateLocation() + emailTemplate.getTemplateName()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (thymeleafTemplate != null) {
			return super.computeTemplateResource(configuration, ownerTemplate, thymeleafTemplate,
					templateResolutionAttributes);
		}
		return null;
	}

}