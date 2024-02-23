rootProject.name = "springboot-multi-module-msa"


include("config-jpa")
include("config-security")

include("boot-gateway")
include("boot-member")


