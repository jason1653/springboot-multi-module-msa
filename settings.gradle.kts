rootProject.name = "springboot-multi-module-msa"


include("boot-gateway")
include("boot-base")
include("boot-product")



include("config-jpa")
include("config-security")


include("common-logger")
include("common-utils")
include("common-response")



