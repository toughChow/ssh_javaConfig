# ssh_javaConfig
  In this case,I used java config to build the ssh framework which replaced *.xml.<br>
  It is a quite greate way to config like this,as most time we write java config at Spring-mvc but not Spring-Struts-Hibernate.
# The way to config struts as follow:
FilterRegistration.Dynamic dispatcher = container.addFilter("*",StrutsPrepareAndExecuteFilter.class );
dispatcher.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/\*");
