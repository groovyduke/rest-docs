grails{
    plugin {
        springsecurity {
            filterChain.chainMap = [
                    [pattern: '/api/appVersion', filters: 'anonymousAuthenticationFilter,restTokenValidationFilter,restExceptionTranslationFilter,filterInvocationInterceptor'],
                    [pattern: '/api/**', filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter'],  // Stateless chain
            ]

            adh {
                // errorPage = '/errorHandler/error'
                errorPage = null
                useForward = false
            }
            auth {
                loginFormUrl = '/module/auth/login'
                useForward = false
            }

            scpf.forceEagerSessionCreation= false

            rest {
                token {
                    validation {
                        enableAnonymousAccess = true
                    }
                    storage {
                        jwt {
                            expiration = 3600 // default expiration to 1 hour
                        }
                    }
                }
            }
        }
    }
}
