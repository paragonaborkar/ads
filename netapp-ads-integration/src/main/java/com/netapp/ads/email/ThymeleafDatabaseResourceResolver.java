package com.netapp.ads.email;

import com.netapp.ads.repos.EmailTemplateRepository;

//@Service
public class ThymeleafDatabaseResourceResolver  {
	
	//@Autowired
	EmailTemplateRepository emailTemplateRepository;

	public ThymeleafDatabaseResourceResolver() {
		//setResolvablePatterns(Sets.newHashSet("*"));
	}

/*	@Override
	protected ITemplateResource computeTemplateResource(IEngineConfiguration configuration, String ownerTemplate,
			String template, Map<String, Object> templateResolutionAttributes) {
		EmailTemplate emailTemplate = emailTemplateRepository.findOneByTemplateName(template);
		String thymeleafTemplate = null;
        try {
            thymeleafTemplate = FileUtils.readFileToString(new File(emailTemplate.getTemplateLocation() + emailTemplate.getTemplateName()));
        } catch (IOException e) {
            log.debuge.getMessage());
        }
        if (thymeleafTemplate != null) {
			return super.computeTemplateResource(configuration, ownerTemplate, thymeleafTemplate,
					templateResolutionAttributes);
		}
		return null;
	}*/

}