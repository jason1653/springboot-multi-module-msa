rootProject.name = "springboot-multi-module-msa"


include("boot-gateway")
include("boot-base")



include("config-jpa")
include("config-security")

include("common-base-model")
include("common-utils")
include("common-response")



