Kettle

Talent

Bonita




passwordPolicy
{
  "global": true,
  "name": "完整密码策略",
  "constrain": {
    "minLength": 8,
    "maxLength": 20,
    "maxDuplicated": 4,
    "blackList": "fuck whore",
    "forbidBlank": 2,
    "forceSpecialLetter": 2,
    "forceNumber": 2,
    "forceCapital": 2,
    "forceLowerCase": 2
  },
  "wrongPasswordPolicy": {
    "lock": {
      "number": 3,
      "time": 10000,
      "timeLimit": 300000,
      "enable": true
    }
  },
  "needCaptcha": true,
  "expireConfig": {
    "expireTime": 2678400000,
    "enable": true
  },
  "range": "PERSON"
}

qqWW22@@


# accountEntity
```
{
    "_id" : "e50d7135-560f-4e3a-b2fb-68a1dbd9247d",
    "_class" : "com.mongodb.BasicDBObject",
    "accountName" : "casAccount3",
    "appId" : "002d753c-9e2c-4d06-b300-54cf236f56f2",
    "enbale" : true,
    "extraProps" : {
        "address-382af08e-4b55-4080-8569-bfd15743587e" : "中国北京市",
        "cellPhone-3a6f8355-4550-4555-ae9a-16d0cafdd2ed" : "13300000000"
    },
    "version" : NumberLong(0)
}
```
```json
{
    "_id" : "382af08e-4b55-4080-8569-bfd15743587e",
    "_class" : "com.mongodb.BasicDBObject",
    "code" : "address",
    "name" : "通讯地址",
    "namespace" : "ACCOUNT-002d753c-9e2c-4d06-b300-54cf236f56f2",
    "type" : "String",
    "indexStatus" : "noIndex",
    "delete" : false,
    "version" : NumberLong(0)
}
```

# userEnttiy
```json
{
    "_id" : "fbda172e-c453-4eb9-b7cc-4346ff8b80ee",
    "_class" : "com.mongodb.BasicDBObject",
    "userName" : "user",
    "displayName" : "普通用户",
    "passWord" : "12345678",
    "email" : "user@id.link",
    "organizationIds" : [
        "eac96b5e-f1ec-48a8-99f8-4c653bd44728"
    ],
    "extraProps" : {
        "idNumber-13e1aed8-1c58-44f8-9972-ecb37820ae12" : "100012199805065648"
    },
    "version" : NumberLong(0)
}
```

```json
{
    "_id" : "13e1aed8-1c58-44f8-9972-ecb37820ae12",
    "_class" : "com.mongodb.BasicDBObject",
    "code" : "idNumber",
    "name" : "身份证号",
    "namespace" : "USER",
    "type" : "String",
    "indexStatus" : "noIndex",
    "delete" : false,
    "version" : NumberLong(0)
}
```



# SSOSelectedVO
```json
{"user":"cas-account-0","value":{"AB":"ba","SE":"nan","HO":"leshan","EM":"111@qq.com","UN":"string1","AN":"cas-account-0"}}
```


# ssoConfigEntity
```json
{
    "appId":"$id-app-0$",
    "type":"jwt",
    "config":{
        "service":"http://localhost:8080/jwt/jwtLogin",
        "user":"user.sdda",
        "mapping":[
            "UN=user.userName",
            "EM=user.email",
            "AB=ba",
            "SE=user.extraProps.firstName",
            "AN=account.accountName",
            "HO=account.extraProps.firstName"
        ]
    }
}
```


# validate-object
@程淼
Collection的比较规则
    1、collection理论上是不需要顺序的，如果src只写了[1,2,3]   target[1,2,3,4,5]
    2、顺序[2,3,1] 和 target:[1,2,3] 或者 [1,2,3,4]
List的比较规则
    同collection相同，特别注意一下顺序是否会被方法考虑

map的比较规则
    src:{k1:1,k2:v2,k3:v3}  target:{k1:1,k2:v2,k3:v3,k4:v4} 会是相等还是不等

Object，比较属性:
    src:{k1:1,k2:v2,k3:v3}  target:{k1:1,k2:v2,k3:v3,k4:v4} 会是相等还是不等


(ArrayList) list = {ArrayList@9719}  size = 3
 0 = {Integer@9737} 1
 1 = {Integer@9738} 2
 2 = {Integer@9739} 3

com.zrkj.commons.testframe.TestFrameworkException: 验证validate-objects出错,key[collection[2]]:[1 3]
com.zrkj.commons.testframe.TestFrameworkException: 验证validate-objects出错,key[collection[2]]:[1 3]
2018-02-06T00:00:00.000+0800
wrapperObject = {WrapperObject@9761}
 integer = {Integer@9780} 1
 string = "2"
 date = {Date@9782} "Tue Feb 06 00:00:00 CST 2018"
 list = {Collections$EmptyList@9783}  size = 0'
{"date":1517846400000,"integer":1,"list":[],"string":"2"}


# 问题
//bug - 比较是有顺序的
src[1,2,3], target[2,3,1]不同

# 详细结果
src[1,2,3], target[1,2,3,4,5]不同
//bug - 比较是有顺序的
src[1,2,3], target[2,3,1]不同
src[1,2,3], target[1,2,3]相同

# oauth

com/zrkj/auth/web/test/service/sso/oauth/yaml/OAuthProcessorTest.yml

apps = {ArrayList@7553}  size = 2
 0 = {AppVO@7584} "{"id":"bbf62a27-cbb1-4e4f-b57a-4c8feaa06f6a","isEnable":false,"label":"label1","name":"name0","regionId":"string","version":0}"
 1 = {AppVO@7585} "{"id":"ef953aa0-7384-40d0-ab34-aceb9dd1a580","isEnable":false,"label":"label3","name":"name2","regionId":"string","version":0}"

appList = {ArrayList@7554}  size = 2
 0 = {AppVO@7562} "{"isEnable":false,"label":"label1","name":"name0","regionId":"string"}"
 1 = {AppVO@7563} "{"isEnable":false,"label":"label3","name":"name2","regionId":"string"}"

vos = {ArrayList@7532}  size = 1
 0 = {AssignEntitlementVO@7538} ""
{
    "accountName":"account-name",
    "entitlementType":"ACCOUNT",
    "operationer":{
        "displayName":"string",
        "enabled":true,
        "id":"92ad45f1-07f2-4436-9bc5-815dc7a28270",
        "userName":"string",
        "version":0
    },
    "user":{
        "displayName":"string2",
        "enabled":true,
        "id":"7487c184-a8f1-44cb-8203-e2a01fde550e",
        "userName":"string2",
        "version":0
    },
    "version":0
}

RoleFacadeTest
    updateRoleUsers2()
SSOConfigFacadeTest
    findSSOConfig()
UserAccountFacadeTest
    findById()

[{"accountId":"2cb66e0b-1423-48ab-b875-4f61f690c925","accountName":"string","appId":"fe9cb203-e848-4c3d-b548-1dc33be3ccc6","appName":"name","enabled":true,"entitlementType":"ACCOUNT","id":"da350e8f-d014-436b-8ee0-682d0094d459","operator":{"displayName":"地球-组织机构管理员","enabled":true,"id":"2a573f0c-a324-4488-a7c4-1c45007754cf","userName":"admin-org","version":0},"userGrants":[{"enabled":true,"user":{"displayName":"地球-组织机构管理员2","enabled":true,"id":"2a3db885-7b74-4acc-8fad-10dee4e6abca","userName":"admin-org2","version":0},"version":0}],"version":0}]
[
    {
        "accountId":"2cb66e0b-1423-48ab-b875-4f61f690c925",
        "accountName":"string",
        "appId":"fe9cb203-e848-4c3d-b548-1dc33be3ccc6",
        "appName":"name",
        "enabled":true,
        "entitlementType":"ACCOUNT",
        "id":"da350e8f-d014-436b-8ee0-682d0094d459",
        "operator":{
            "displayName":"地球-组织机构管理员",
            "enabled":true,
            "id":"2a573f0c-a324-4488-a7c4-1c45007754cf",
            "userName":"admin-org",
            "version":0
        },
        "userGrants":[
            {
                "enabled":true,
                "user":{
                    "displayName":"地球-组织机构管理员2",
                    "enabled":true,
                    "id":"2a3db885-7b74-4acc-8fad-10dee4e6abca",
                    "userName":"admin-org2",
                    "version":0
                },
                "version":0
            }
        ],
        "version":0
    }
]

{"cas":[{"code":"service","description":"应用接受CAS Ticket的URL地址","displayName":"SP Service URL","fieldType":"String","validates":["required","url"]},{"code":"user","description":"CAS XML中的<user>元素值","displayName":"CAS账号名","fieldType":"String","validates":["required"]},{"code":"attributes","description":"CAS XML中的<attributes>元素值","displayName":"CAS账号属性","fieldType":"Map","validates":[]}],"jwt":[{"code":"service","description":"应用接受JWT Token的URL地址","displayName":"SP Service URL","fieldType":"String","validates":["required","url"]},{"code":"user","description":"","displayName":"JWT账号名","fieldType":"String","validates":["required"]},{"code":"attributes","description":"","displayName":"JWT账号属性","fieldType":"Map","validates":[]}],"openid":[{"code":"callback","description":"","displayName":"","fieldType":"String","validates":[]}],"saml2":[{"code":"sp","description":"应用接受saml返回消息的URL地址","displayName":"SP Service URL","fieldType":"String","validates":["required","url"]},{"code":"AudienceURI","description":"应用接受saml返回消息的URL地址","displayName":"SP Service URL","fieldType":"String","validates":["required","url"]},{"code":"user","description":"SAML XML中的<saml2:NameID>元素值","displayName":"SAML账号名","fieldType":"String","validates":["required"]},{"code":"attributes","description":"SAML XML中的<attributes>元素值","displayName":"SAML账号属性","fieldType":"Map","validates":[]}],"oauth":[{"code":"service","description":"回调地址","displayName":"SP Service URL","fieldType":"String","validates":["required","url"]},{"code":"user.","description":"OAuth XML中的<user>元素值","displayName":"OAuth账号名","fieldType":"String","validates":["required"]},{"code":"attributes","description":"OAuth XML中的<attributes>元素值","displayName":"OAuth账号属性","fieldType":"Map","validates":[]}]}
{
    "cas":[
        {
            "code":"service",
            "description":"应用接受CAS Ticket的URL地址",
            "displayName":"SP Service URL",
            "fieldType":"String",
            "validates":[
                "required",
                "url"
            ]
        },
        {
            "code":"user",
            "description":"CAS XML中的<user>元素值",
            "displayName":"CAS账号名",
            "fieldType":"String",
            "validates":[
                "required"
            ]
        },
        {
            "code":"attributes",
            "description":"CAS XML中的<attributes>元素值",
            "displayName":"CAS账号属性",
            "fieldType":"Map",
            "validates":[

            ]
        }
    ],
    "jwt":[
        {
            "code":"service",
            "description":"应用接受JWT Token的URL地址",
            "displayName":"SP Service URL",
            "fieldType":"String",
            "validates":[
                "required",
                "url"
            ]
        },
        {
            "code":"user",
            "description":"",
            "displayName":"JWT账号名",
            "fieldType":"String",
            "validates":[
                "required"
            ]
        },
        {
            "code":"attributes",
            "description":"",
            "displayName":"JWT账号属性",
            "fieldType":"Map",
            "validates":[

            ]
        }
    ],
    "openid":[
        {
            "code":"callback",
            "description":"",
            "displayName":"",
            "fieldType":"String",
            "validates":[

            ]
        }
    ],
    "saml2":[
        {
            "code":"sp",
            "description":"应用接受saml返回消息的URL地址",
            "displayName":"SP Service URL",
            "fieldType":"String",
            "validates":[
                "required",
                "url"
            ]
        },
        {
            "code":"AudienceURI",
            "description":"应用接受saml返回消息的URL地址",
            "displayName":"SP Service URL",
            "fieldType":"String",
            "validates":[
                "required",
                "url"
            ]
        },
        {
            "code":"user",
            "description":"SAML XML中的<saml2:NameID>元素值",
            "displayName":"SAML账号名",
            "fieldType":"String",
            "validates":[
                "required"
            ]
        },
        {
            "code":"attributes",
            "description":"SAML XML中的<attributes>元素值",
            "displayName":"SAML账号属性",
            "fieldType":"Map",
            "validates":[

            ]
        }
    ],
    "oauth":[
        {
            "code":"service",
            "description":"回调地址",
            "displayName":"SP Service URL",
            "fieldType":"String",
            "validates":[
                "required",
                "url"
            ]
        },
        {
            "code":"user.",
            "description":"OAuth XML中的<user>元素值",
            "displayName":"OAuth账号名",
            "fieldType":"String",
            "validates":[
                "required"
            ]
        },
        {
            "code":"attributes",
            "description":"OAuth XML中的<attributes>元素值",
            "displayName":"OAuth账号属性",
            "fieldType":"Map",
            "validates":[

            ]
        }
    ]
}


# sms配置文件

qqw w22 @@ WW
-Dspring.profiles.active=dev
qqWW22@@


java -Dspring.profiles.active=dev -cp target/admin-web-1.0-SNAPSHOT.jar  com.zrkj.admin.web.WebApplication --spring.config.location=file:config/ --spring.config.name=mycfg-sms
administration/admin-web

java -Dspring.profiles.active=dev -cp target/authentication-web-1.0-SNAPSHOT.jar com.zrkj.auth.web.AuthWebApplication --spring.config.location=file:config/ --spring.config.name=mycfg-sms
java -Dspring.profiles.active=dev -cp target/authentication-web-1.0-SNAPSHOT.jar com.zrkj.auth.web.AuthWebApplication --spring.config.location=file:config/ --spring.config.name=mycfg-sms
java -Dspring.profiles.active=dev -cp target/authentication-web-1.0-SNAPSHOT.jar com.zrkj.auth.web.AuthWebApplication --spring.config.location=D:/programe/eclipse-jee-luna-SR1a-win32-x86_64/idlink/authentication/authentication-web/config/mycfg-sms.properties
--spring.config.location=D:/programe/eclipse-jee-luna-SR1a-win32-x86_64/idlink/authentication/authentication-web/config/mycfg-sms.properties

idlink
├── administration
│   ├── admin-api
│   │   ├── admin-api.iml
│   │   ├── pom.xml
│   │   └── src
│   │       └── main
│   │           └── java
│   │               └── com
│   │                   └── zrkj
│   │                       └── admin
│   │                           └── api
│   │                               ├── dto
│   │                               │   ├── account
│   │                               │   │   ├── AccountAddDto.java
│   │                               │   │   ├── AccountApplyAddDto.java
│   │                               │   │   ├── AccountApplyQueryDto.java
│   │                               │   │   ├── AccountDto.java
│   │                               │   │   ├── AccountUpdateDto.java
│   │                               │   │   ├── ProvisionAddDto.java
│   │                               │   │   └── ProvisionUpdateDto.java
│   │                               │   ├── app
│   │                               │   │   ├── AppDto.java
│   │                               │   │   ├── AppGrantAddDto.java
│   │                               │   │   ├── AppGrantDeleteDto.java
│   │                               │   │   ├── SSOAddDto.java
│   │                               │   │   └── SSOUpdateDto.java
│   │                               │   ├── entitlement
│   │                               │   │   ├── EntitlementDeleteDto.java
│   │                               │   │   └── EntitlementLifecycleUpdateDto.java
│   │                               │   ├── ImageDto.java
│   │                               │   ├── metaProperty
│   │                               │   │   ├── MetaPropertyAddDto.java
│   │                               │   │   └── MetaPropertyUpdateDto.java
│   │                               │   ├── organization
│   │                               │   │   ├── OrganizationAddDto.java
│   │                               │   │   ├── OrganizationDto.java
│   │                               │   │   └── OrganizationUpdateDto.java
│   │                               │   ├── password
│   │                               │   │   └── policy
│   │                               │   │       ├── Captcha.java
│   │                               │   │       ├── Constrain.java
│   │                               │   │       ├── ExpireConfig.java
│   │                               │   │       ├── Lock.java
│   │                               │   │       ├── PasswordPolicyAddDto.java
│   │                               │   │       ├── PasswordPolicyUpdateDto.java
│   │                               │   │       └── WrongPasswordPolicy.java
│   │                               │   ├── permission
│   │                               │   │   ├── RegionOwnerUpdateDto.java
│   │                               │   │   ├── RoleDto.java
│   │                               │   │   ├── RolePermissionDto.java
│   │                               │   │   ├── RolePermissionUpdateDto.java
│   │                               │   │   ├── RoleUsersUpdateDto.java
│   │                               │   │   └── UserRoleDto.java
│   │                               │   ├── PropertyValueDto.java
│   │                               │   ├── query
│   │                               │   │   ├── Filter.java
│   │                               │   │   ├── Match.java
│   │                               │   │   ├── QueryDto.java
│   │                               │   │   ├── QueryModeConstant.java
│   │                               │   │   └── QueryTypeConstant.java
│   │                               │   ├── RegionAddDto.java
│   │                               │   ├── RegionDto.java
│   │                               │   ├── strategy
│   │                               │   │   ├── StrategyAddDto.java
│   │                               │   │   └── StrategyUpdateDto.java
│   │                               │   ├── user
│   │                               │   │   ├── UserCountSearchDto.java
│   │                               │   │   ├── UserLifecycleUpdateDto.java
│   │                               │   │   └── UserSearchDto.java
│   │                               │   └── validate
│   │                               │       ├── AccountDeletePermissionDto.java
│   │                               │       ├── AccountPermissionDto.java
│   │                               │       ├── OrganizationPermissionDto.java
│   │                               │       ├── RegionPermissionDto.java
│   │                               │       ├── UserDeletePermissionDto.java
│   │                               │       └── UserUpdatePermissionDto.java
│   │                               ├── IAccountApply.java
│   │                               ├── IAccountManagement.java
│   │                               ├── IAccountProvision.java
│   │                               ├── IAppGrant.java
│   │                               ├── IAppManagement.java
│   │                               ├── IAuthAccount.java
│   │                               ├── IEntitlement.java
│   │                               ├── IMetaProperty.java
│   │                               ├── IOrganization.java
│   │                               ├── IPassword.java
│   │                               ├── IPasswordPolicy.java
│   │                               ├── IRegion.java
│   │                               ├── IRole.java
│   │                               ├── ISSOConfigManagement.java
│   │                               ├── IStrategy.java
│   │                               ├── ITest.java
│   │                               ├── IUserAccount.java
│   │                               ├── IUserRole.java
│   │                               ├── permissionValidate
│   │                               │   └── IAccountPermissionValidate.java
│   │                               ├── validate
│   │                               │   ├── IAppValidate.java
│   │                               │   └── IPermissionValidate.java
│   │                               └── vo
│   │                                   ├── account
│   │                                   │   ├── AccountApplyAddVO.java
│   │                                   │   ├── AccountApplyVO.java
│   │                                   │   ├── AccountDetailVO.java
│   │                                   │   └── AccountEntitlementVO.java
│   │                                   ├── app
│   │                                   │   ├── SSOAddVO.java
│   │                                   │   ├── SSOAttributeVO.java
│   │                                   │   ├── SSOConfigVO.java
│   │                                   │   └── SSOUpdateVO.java
│   │                                   ├── MetaPropertyVO.java
│   │                                   ├── organization
│   │                                   │   ├── OrganizationVO.java
│   │                                   │   ├── OrganizationWithPathAndVersionVO.java
│   │                                   │   └── OrganizationWithPathVO.java
│   │                                   ├── PasswordPolicyVO.java
│   │                                   ├── permission
│   │                                   │   ├── PermissionVO.java
│   │                                   │   ├── RegionDetailVO.java
│   │                                   │   └── RegionTreeNodeVO.java
│   │                                   ├── RegionVO.java
│   │                                   ├── RoleVO.java
│   │                                   ├── strategy
│   │                                   │   ├── AppStrategyVO.java
│   │                                   │   ├── AuthMethodVO.java
│   │                                   │   ├── StrategyAddVO.java
│   │                                   │   ├── StrategyUpdateVO.java
│   │                                   │   └── StrategyVO.java
│   │                                   └── user
│   │                                       └── UserMentionVO.java
│   ├── admin-impl
│   │   ├── admin-impl.iml
│   │   ├── pom.xml
│   │   └── src
│   │       ├── main
│   │       │   ├── java
│   │       │   │   └── com
│   │       │   │       └── zrkj
│   │       │   │           └── admin
│   │       │   │               └── impl
│   │       │   │                   ├── Application.java
│   │       │   │                   ├── facade
│   │       │   │                   │   ├── AccountApplyFacade.java
│   │       │   │                   │   ├── AccountManagementFacade.java
│   │       │   │                   │   ├── AccountPermissionValidateFacade.java
│   │       │   │                   │   ├── AccountProvisionFacade.java
│   │       │   │                   │   ├── AppGrantFacade.java
│   │       │   │                   │   ├── AppManagementFacade.java
│   │       │   │                   │   ├── AppValidateFacade.java
│   │       │   │                   │   ├── AuthAccountFacade.java
│   │       │   │                   │   ├── EntitlementFacade.java
│   │       │   │                   │   ├── MetaPropertyFacade.java
│   │       │   │                   │   ├── OrganizationFacade.java
│   │       │   │                   │   ├── PasswordFacade.java
│   │       │   │                   │   ├── PasswordPolicyFacade.java
│   │       │   │                   │   ├── PermissionValidateFacade.java
│   │       │   │                   │   ├── RegionFacade.java
│   │       │   │                   │   ├── RoleFacade.java
│   │       │   │                   │   ├── SSOConfigFacade.java
│   │       │   │                   │   ├── StrategyFacade.java
│   │       │   │                   │   ├── TestFacade.java
│   │       │   │                   │   ├── UserAccountFacade.java
│   │       │   │                   │   └── UserRoleFacade.java
│   │       │   │                   └── Swagger2.java
│   │       │   └── resources
│   │       │       ├── application.properties
│   │       │       ├── application.yml
│   │       │       ├── application-ci.yml
│   │       │       ├── application-unit_test.yml
│   │       │       ├── email.properties
│   │       │       └── logback.xml
│   │       └── test
│   │           └── java
│   │               └── com
│   │                   └── zrkj
│   │                       └── admin
│   │                           ├── service
│   │                           │   └── permission
│   │                           ├── sms
│   │                           │   └── SmsWebChineseTest.java
│   │                           └── test
│   │                               ├── BaseContextTest.java
│   │                               ├── dao
│   │                               │   └── AuthAccountControllerTest.java
│   │                               ├── facade
│   │                               │   ├── AccountApplyFacadeTest.java
│   │                               │   ├── AccountFacadeTest.java
│   │                               │   ├── AccountPermissionValidateFacadeTest.java
│   │                               │   ├── AccountProvisionFacadeTest.java
│   │                               │   ├── AppFacadeTest.java
│   │                               │   ├── AppGrantFacadeTest.java
│   │                               │   ├── AppValidateFacadeTest.java
│   │                               │   ├── EntitlementFacadeTest.java
│   │                               │   ├── LoginEventTest.java
│   │                               │   ├── MetaPropertyFacadeTest.java
│   │                               │   ├── OrganizationFacadeTest.java
│   │                               │   ├── PasswordFacadeTest.java
│   │                               │   ├── PasswordPolicyFacadeTest.java
│   │                               │   ├── PermissionValidateFacadeTest.java
│   │                               │   ├── RegionFacadeTest.java
│   │                               │   ├── RoleFacadeTest.java
│   │                               │   ├── SSOConfigFacadeTest.java
│   │                               │   ├── SSOPropertyParserTest.java
│   │                               │   ├── StrategyFacadeTest.java
│   │                               │   ├── UserAccountFacadeTest.java
│   │                               │   ├── UserRoleFacadeTest.java
│   │                               │   └── yaml
│   │                               │       ├── AccountApplyFacadeTest.yml
│   │                               │       ├── AccountFacadeTest.yml
│   │                               │       ├── AccountPermissionValidateFacadeTest.yml
│   │                               │       ├── AccountProvisionFacadeTest.yml
│   │                               │       ├── AppFacadeTest.yml
│   │                               │       ├── AppGrantFacadeTest.yml
│   │                               │       ├── AppValidateFacadeTest.yml
│   │                               │       ├── EntitlementFacadeTest.yml
│   │                               │       ├── LoginEventTest.yml
│   │                               │       ├── MetaPropertyFacadeTest.yml
│   │                               │       ├── OrganizationFacadeTest.yml
│   │                               │       ├── PasswordFacadeTest.yml
│   │                               │       ├── PasswordPolicyFacadeTest.yml
│   │                               │       ├── PermissionValidateFacadeTest.yml
│   │                               │       ├── RegionFacadeTest.yml
│   │                               │       ├── RoleFacadeTest.yml
│   │                               │       ├── SSOConfigFacadeTest.yml
│   │                               │       ├── SSOPropertyParserTest.yml
│   │                               │       ├── StrategyFacadeTest.yml
│   │                               │       ├── UserAccountFacadeTest.yml
│   │                               │       └── UserRoleFacadeTest.yml
│   │                               ├── service
│   │                               │   ├── MessageServiceTest.java
│   │                               │   ├── permission
│   │                               │   │   ├── PermissionAnnotation.java
│   │                               │   │   ├── PermissionAnnotationTest.java
│   │                               │   │   ├── PermissionServiceTest.java
│   │                               │   │   ├── PermissionTestDto.java
│   │                               │   │   ├── RegionServiceTest.java
│   │                               │   │   └── yaml
│   │                               │   │       ├── PermissionAnnotationTest.yml
│   │                               │   │       ├── PermissionServiceTest.yml
│   │                               │   │       └── RegionServiceTest.yml
│   │                               │   ├── query
│   │                               │   │   ├── QueryServiceTest.java
│   │                               │   │   └── yaml
│   │                               │   │       └── QueryServiceTest.yml
│   │                               │   └── yaml
│   │                               │       └── MessageServiceTest.yml
│   │                               └── utils
│   │                                   └── CommonTest.java
│   ├── administration.iml
│   ├── admin-service
│   │   ├── admin-service.iml
│   │   ├── pom.xml
│   │   └── src
│   │       └── main
│   │           ├── java
│   │           │   └── com
│   │           │       └── zrkj
│   │           │           └── admin
│   │           │               └── service
│   │           │                   ├── account
│   │           │                   │   ├── AccountApplyService.java
│   │           │                   │   ├── AccountProvisionService.java
│   │           │                   │   └── AccountService.java
│   │           │                   ├── AppGrantService.java
│   │           │                   ├── AppService.java
│   │           │                   ├── AppValidateService.java
│   │           │                   ├── AuthService.java
│   │           │                   ├── config
│   │           │                   │   └── AdminConfig.java
│   │           │                   ├── EntitlementService.java
│   │           │                   ├── ImageService.java
│   │           │                   ├── MessageService.java
│   │           │                   ├── MetaPropertyService.java
│   │           │                   ├── organization
│   │           │                   │   ├── OrganizationConstant.java
│   │           │                   │   └── OrganizationService.java
│   │           │                   ├── password
│   │           │                   │   ├── PasswordPolicyService.java
│   │           │                   │   └── PasswordService.java
│   │           │                   ├── permission
│   │           │                   │   ├── AccountPermissionService.java
│   │           │                   │   ├── aspect
│   │           │                   │   │   ├── Permission.java
│   │           │                   │   │   └── PermissionAspect.java
│   │           │                   │   ├── check
│   │           │                   │   │   ├── IResourceCheck.java
│   │           │                   │   │   ├── PermissionCheckFactory.java
│   │           │                   │   │   ├── PermissionCheckOrganizationCodeImpl.java
│   │           │                   │   │   └── PermissionCheckUserImpl.java
│   │           │                   │   ├── model
│   │           │                   │   │   └── PermissionModel.java
│   │           │                   │   ├── PermissionResourceConstants.java
│   │           │                   │   ├── PermissionService.java
│   │           │                   │   ├── RegionService.java
│   │           │                   │   ├── RoleService.java
│   │           │                   │   └── UserRoleService.java
│   │           │                   ├── query
│   │           │                   │   └── QueryService.java
│   │           │                   ├── sso
│   │           │                   │   └── SSOConfigService.java
│   │           │                   ├── StrategyService.java
│   │           │                   ├── TestService.java
│   │           │                   ├── UserService.java
│   │           │                   ├── utils
│   │           │                   │   ├── AccountApplyEntityUtils.java
│   │           │                   │   ├── AccountEntitlementUtils.java
│   │           │                   │   ├── AccountEntityUtils.java
│   │           │                   │   ├── BaseEntityUtils.java
│   │           │                   │   ├── OrganizationEntityUtils.java
│   │           │                   │   ├── PasswordPolicyEntityUtils.java
│   │           │                   │   ├── SSOConfigEntityUtils.java
│   │           │                   │   └── StrategyUtils.java
│   │           │                   └── ValidateService.java
│   │           └── resources
│   │               └── adminConfig.properties
│   ├── admin-web
│   │   ├── admin-web.iml
│   │   ├── config
│   │   │   └── mycfg-sms.properties
│   │   ├── pom.xml
│   │   └── src
│   │       └── main
│   │           ├── java
│   │           │   └── com
│   │           │       └── zrkj
│   │           │           └── admin
│   │           │               └── web
│   │           │                   ├── annotation
│   │           │                   │   └── Swagger2.java
│   │           │                   ├── aspect
│   │           │                   │   └── permission
│   │           │                   │       ├── Login.java
│   │           │                   │       ├── LoginAspect.java
│   │           │                   │       ├── WebPermission.java
│   │           │                   │       └── WebPermissionAspect.java
│   │           │                   ├── controller
│   │           │                   │   ├── AccountApplyController.java
│   │           │                   │   ├── AccountController.java
│   │           │                   │   ├── AccountProvisionController.java
│   │           │                   │   ├── AdminPasswordController.java
│   │           │                   │   ├── AdminPasswordPolicyController.java
│   │           │                   │   ├── AppController.java
│   │           │                   │   ├── AppGrantController.java
│   │           │                   │   ├── EntitlementController.java
│   │           │                   │   ├── LoginController.java
│   │           │                   │   ├── MetaPropertyController.java
│   │           │                   │   ├── OrganizationController.java
│   │           │                   │   ├── RegionController.java
│   │           │                   │   ├── RoleController.java
│   │           │                   │   ├── SSOConfigController.java
│   │           │                   │   ├── StrategyController.java
│   │           │                   │   ├── TestController.java
│   │           │                   │   └── UserController.java
│   │           │                   ├── filter
│   │           │                   │   ├── LoginFilter.java
│   │           │                   │   └── utils
│   │           │                   │       └── AdminLoginFilterUtils.java
│   │           │                   ├── init
│   │           │                   │   ├── SystemInitiator.java
│   │           │                   │   └── yaml
│   │           │                   │       └── SystemInitiator.yml
│   │           │                   ├── service
│   │           │                   │   └── AdminVerifyCodeService.java
│   │           │                   └── WebApplication.java
│   │           └── resources
│   │               ├── adminLoginFilterUtils.yml
│   │               ├── application.properties
│   │               ├── application.yml
│   │               ├── application-ci.yml
│   │               ├── application-dev.yml
│   │               ├── application-prod.yml
│   │               ├── application-test.yml
│   │               ├── application-unit_test.yml
│   │               └── logback.xml
│   └── pom.xml
├── authentication
│   ├── authentication.iml
│   ├── authentication-api
│   │   ├── authentication-api.iml
│   │   ├── pom.xml
│   │   └── src
│   │       └── main
│   │           └── java
│   │               └── com
│   │                   └── zrkj
│   │                       └── auth
│   │                           └── api
│   │                               ├── constants
│   │                               │   ├── RedisKeyConstant.java
│   │                               │   └── URLConstant.java
│   │                               ├── dto
│   │                               │   ├── login
│   │                               │   │   ├── LoginDto.java
│   │                               │   │   └── QRCodeLoginDto.java
│   │                               │   ├── PasswordLoginDto.java
│   │                               │   ├── PasswordTicketDto.java
│   │                               │   ├── PasswordUpdateDto.java
│   │                               │   ├── SSOInfo.java
│   │                               │   └── UserLoginDto.java
│   │                               ├── ExcludeMicroServiceAnnotation.java
│   │                               ├── IAuthApp.java
│   │                               ├── IAuthPassword.java
│   │                               ├── IDeviceBinding.java
│   │                               ├── IJwtKey.java
│   │                               ├── ILogin.java
│   │                               ├── IMobileToken.java
│   │                               ├── IOAuth.java
│   │                               ├── IPasswordLogin.java
│   │                               ├── IPasswordMaintenance.java
│   │                               ├── IQRCodeLogin.java
│   │                               ├── ISmsBinding.java
│   │                               ├── IUserLogin.java
│   │                               └── vo
│   │                                   ├── LoginVO.java
│   │                                   ├── OAuthInfoVO.java
│   │                                   ├── PasswordEmailVO.java
│   │                                   ├── QRCodeLoginVO.java
│   │                                   ├── SMSPasswordVO.java
│   │                                   ├── SmsVO.java
│   │                                   ├── UserAndAccountVO.java
│   │                                   └── UserLoginVO.java
│   ├── authentication-impl
│   │   ├── authentication-impl.iml
│   │   ├── pom.xml
│   │   └── src
│   │       └── main
│   │           ├── java
│   │           │   └── com
│   │           │       └── zrkj
│   │           │           └── auth
│   │           │               └── impl
│   │           │                   ├── AuthApplication.java
│   │           │                   ├── facade
│   │           │                   │   ├── AuthAppFacade.java
│   │           │                   │   ├── AuthPasswordFacade.java
│   │           │                   │   ├── DeviceBindingFacade.java
│   │           │                   │   ├── JwtKeyFacade.java
│   │           │                   │   ├── MobileTokenFacade.java
│   │           │                   │   ├── OAuthFacade.java
│   │           │                   │   ├── PasswordLoginFacade.java
│   │           │                   │   ├── PasswordMaintenanceFacade.java
│   │           │                   │   ├── QRCodeLoginFacade.java
│   │           │                   │   ├── SmsBindingFacade.java
│   │           │                   │   └── UserLoginFacade.java
│   │           │                   ├── LoginFacade.java
│   │           │                   └── Swagger2.java
│   │           └── resources
│   │               ├── email.properties
│   │               └── jwt.properties
│   ├── authentication-service
│   │   ├── authentication-service.iml
│   │   ├── pom.xml
│   │   └── src
│   │       └── main
│   │           └── java
│   │               └── com
│   │                   └── zrkj
│   │                       └── auth
│   │                           ├── config
│   │                           │   └── AuthConfig.java
│   │                           └── service
│   │                               ├── auth
│   │                               │   ├── DeviceBindingService.java
│   │                               │   └── PasswordMaintenanceService.java
│   │                               ├── AuthAppService.java
│   │                               ├── AuthSSOConfigService.java
│   │                               ├── MobileTokenService.java
│   │                               ├── password
│   │                               │   ├── AuthPasswordService.java
│   │                               │   ├── AuthProcessionChainConfigure.java
│   │                               │   ├── LoginErrorType.java
│   │                               │   ├── processor
│   │                               │   │   ├── CheckLoggedStateProcessor.java
│   │                               │   │   ├── CheckPasswordPolicyProcessor.java
│   │                               │   │   ├── CheckVerifyCode.java
│   │                               │   │   ├── CheckVerifyCodeEnable.java
│   │                               │   │   ├── LockProcessor.java
│   │                               │   │   └── LoginProcessor.java
│   │                               │   └── UserStatus.java
│   │                               ├── qrcode
│   │                               │   ├── QRCodeLoginService.java
│   │                               │   └── QRCodeLoginStatus.java
│   │                               ├── sms
│   │                               │   ├── SmsBindingService.java
│   │                               │   └── SmsStatus.java
│   │                               ├── sso
│   │                               │   ├── cas
│   │                               │   │   ├── CasSSOProcessor.java
│   │                               │   │   ├── CasTicket.java
│   │                               │   │   └── CasTicketService.java
│   │                               │   ├── ISSOProcessor.java
│   │                               │   ├── jwt
│   │                               │   │   ├── JwtKeyService.java
│   │                               │   │   ├── JwtSSOProcessor.java
│   │                               │   │   ├── JwtTokenService.java
│   │                               │   │   └── SSOJwtConfig.java
│   │                               │   ├── oauth
│   │                               │   │   ├── OAuthCodeService.java
│   │                               │   │   └── OAuthSSOProcessor.java
│   │                               │   ├── saml2
│   │                               │   │   └── Saml2SSOProcessor.java
│   │                               │   ├── SSOAccountService.java
│   │                               │   ├── SSOFactory.java
│   │                               │   └── SSOSelectedPropService.java
│   │                               ├── UserLoginService.java
│   │                               └── utils
│   │                                   ├── OpenSAMLUtils.java
│   │                                   ├── SmsBindingKeyUtils.java
│   │                                   └── SmsEntityUtils.java
│   ├── authentication-web
│   │   ├── authentication-web.iml
│   │   ├── config
│   │   │   ├── application.properties
│   │   │   ├── application-dev.properties
│   │   │   ├── mycfg-sms.properties
│   │   │   ├── root-cert.pem
│   │   │   ├── root-key.pem
│   │   │   └── templates
│   │   │       └── saml2-post-binding.vm
│   │   ├── pom.xml
│   │   └── src
│   │       ├── main
│   │       │   ├── java
│   │       │   │   └── com
│   │       │   │       └── zrkj
│   │       │   │           └── auth
│   │       │   │               └── web
│   │       │   │                   ├── annotation
│   │       │   │                   │   ├── SAMLInitiator.java
│   │       │   │                   │   └── Swagger2.java
│   │       │   │                   ├── AuthWebApplication.java
│   │       │   │                   ├── controller
│   │       │   │                   │   ├── auth
│   │       │   │                   │   │   └── PasswordMaintenanceController.java
│   │       │   │                   │   ├── AuthAppController.java
│   │       │   │                   │   ├── AuthPasswordController.java
│   │       │   │                   │   ├── device
│   │       │   │                   │   │   ├── DeviceBindingController.java
│   │       │   │                   │   │   ├── MobileTokenController.java
│   │       │   │                   │   │   └── SmsBindingController.java
│   │       │   │                   │   ├── JSPController.java
│   │       │   │                   │   ├── login
│   │       │   │                   │   │   ├── PasswordLoginController.java
│   │       │   │                   │   │   ├── QRCodeLoginController.java
│   │       │   │                   │   │   └── UserLoginController.java
│   │       │   │                   │   ├── LoginController.java
│   │       │   │                   │   ├── RunAppController.java
│   │       │   │                   │   ├── sso
│   │       │   │                   │   │   ├── cas
│   │       │   │                   │   │   │   ├── CasController.java
│   │       │   │                   │   │   │   └── CasLoginController.java
│   │       │   │                   │   │   ├── jwt
│   │       │   │                   │   │   │   └── JwtKeyController.java
│   │       │   │                   │   │   ├── oauth
│   │       │   │                   │   │   │   ├── OAuthController.java
│   │       │   │                   │   │   │   └── OAuthLoginController.java
│   │       │   │                   │   │   └── SSOLoginController.java
│   │       │   │                   │   ├── SSOLoginHandler.java
│   │       │   │                   │   └── TestController.java
│   │       │   │                   ├── filter
│   │       │   │                   │   ├── AjaxFilter.java
│   │       │   │                   │   ├── AuthLoginFilter.java
│   │       │   │                   │   └── utils
│   │       │   │                   │       └── AuthLoginFilterUtil.java
│   │       │   │                   ├── service
│   │       │   │                   │   └── AuthVerifyCodeService.java
│   │       │   │                   ├── utils
│   │       │   │                   │   └── SpringWebClientErrorDecoder.java
│   │       │   │                   └── vo
│   │       │   │                       └── LoginSuccessVO.java
│   │       │   ├── resources
│   │       │   │   ├── application.properties
│   │       │   │   ├── application.yml
│   │       │   │   ├── application-ci.yml
│   │       │   │   ├── application-dev.yml
│   │       │   │   ├── application-prod.yml
│   │       │   │   ├── application-test.yml
│   │       │   │   ├── application-unit_test.yml
│   │       │   │   ├── authLoginFilterUtil.yml
│   │       │   │   ├── logback.xml
│   │       │   │   ├── root-cert.pem
│   │       │   │   ├── root-key.pem
│   │       │   │   └── templates
│   │       │   │       └── saml2-post-binding.vm
│   │       │   └── webapp
│   │       │       ├── css
│   │       │       │   ├── images
│   │       │       │   │   ├── ui-icons_444444_256x240.png
│   │       │       │   │   ├── ui-icons_555555_256x240.png
│   │       │       │   │   ├── ui-icons_777620_256x240.png
│   │       │       │   │   ├── ui-icons_777777_256x240.png
│   │       │       │   │   ├── ui-icons_cc0000_256x240.png
│   │       │       │   │   └── ui-icons_ffffff_256x240.png
│   │       │       │   ├── jquery-ui.css
│   │       │       │   ├── jquery-ui.min.css
│   │       │       │   ├── jquery-ui.structure.css
│   │       │       │   ├── jquery-ui.structure.min.css
│   │       │       │   ├── jquery-ui.theme.css
│   │       │       │   └── jquery-ui.theme.min.css
│   │       │       ├── js
│   │       │       │   ├── common.js
│   │       │       │   ├── jquery-1.12.4.js
│   │       │       │   ├── jquery-ui.js
│   │       │       │   └── jquery-ui.min.js
│   │       │       └── WEB-INF
│   │       │           └── jsp
│   │       │               ├── chooseAccount.jsp
│   │       │               ├── error.jsp
│   │       │               ├── index.jsp
│   │       │               └── myapp.jsp
│   │       └── test
│   │           └── java
│   │               └── com
│   │                   └── zrkj
│   │                       └── auth
│   │                           ├── service
│   │                           ├── sms
│   │                           │   └── SmsWebChineseTest.java
│   │                           └── web
│   │                               └── test
│   │                                   ├── BaseContextTest.java
│   │                                   ├── CommonTest.java
│   │                                   ├── facade
│   │                                   │   ├── AppFacadeTest.java
│   │                                   │   ├── AuthPasswordFacadeTest.java
│   │                                   │   ├── DeviceBindingFacadeTest.java
│   │                                   │   ├── PasswordLoginFacadeTest.java
│   │                                   │   ├── PasswordMaintenanceTest.java
│   │                                   │   ├── QRCodeLoginFacadeTest.java
│   │                                   │   └── yaml
│   │                                   │       ├── AppFacadeTest.yml
│   │                                   │       ├── AuthPasswordFacadeTest.yml
│   │                                   │       ├── DeviceBindingFacadeTest.yml
│   │                                   │       ├── PasswordLoginFacadeTest.yml
│   │                                   │       ├── PasswordMaintenanceTest.yml
│   │                                   │       └── QRCodeLoginFacadeTest.yml
│   │                                   └── service
│   │                                       ├── AuthAppServiceTest.java
│   │                                       ├── CasControllerTest.java
│   │                                       ├── SamlTest.java
│   │                                       ├── sso
│   │                                       │   ├── jwt
│   │                                       │   │   ├── JWTProcessorTest.java
│   │                                       │   │   └── yaml
│   │                                       │   │       └── JWTProcessorTest.yml
│   │                                       │   ├── oauth
│   │                                       │   │   ├── OAuthProcessorTest.java
│   │                                       │   │   └── yaml
│   │                                       │   │       └── OAuthProcessorTest.yml
│   │                                       │   └── saml
│   │                                       │       ├── Saml2ProcessorTest.java
│   │                                       │       └── yaml
│   │                                       │           └── Saml2ProcessorTest.yml
│   │                                       ├── SSOSelectedPropTest.java
│   │                                       └── yaml
│   │                                           ├── AuthAppServiceTest.yml
│   │                                           ├── CasControllerTest.yml
│   │                                           └── SSOSelectedPropTest.yml
│   ├── pom.xml
│   └── README.md
├── base.iml
├── infrastructure
│   ├── inf-commons
│   │   ├── inf-commons.iml
│   │   ├── pom.xml
│   │   └── src
│   │       ├── main
│   │       │   ├── java
│   │       │   │   └── com
│   │       │   │       └── zrkj
│   │       │   │           └── commons
│   │       │   │               ├── annotation
│   │       │   │               │   └── PerformanceLog.java
│   │       │   │               ├── aspect
│   │       │   │               │   └── PerformanceLogAspect.java
│   │       │   │               ├── audit
│   │       │   │               │   ├── AuditLog.java
│   │       │   │               │   ├── AuditModel.java
│   │       │   │               │   ├── LoginAudit.java
│   │       │   │               │   └── OperateAudit.java
│   │       │   │               ├── base
│   │       │   │               │   └── AbstractExtraProps.java
│   │       │   │               ├── codec
│   │       │   │               │   └── KeyUtils.java
│   │       │   │               ├── constants
│   │       │   │               │   ├── DeviceConstants.java
│   │       │   │               │   ├── MessageConstants.java
│   │       │   │               │   ├── MetaPropertyConstants.java
│   │       │   │               │   ├── PasswordPolicyConstant.java
│   │       │   │               │   ├── QRCodeConstants.java
│   │       │   │               │   ├── SensitiveConstants.java
│   │       │   │               │   ├── sso
│   │       │   │               │   │   └── SamlConstants.java
│   │       │   │               │   ├── SSOConfigConstants.java
│   │       │   │               │   └── WebConstants.java
│   │       │   │               ├── CurrentLoginUser.java
│   │       │   │               ├── dto
│   │       │   │               │   ├── AppAddDto.java
│   │       │   │               │   ├── AppUpdateDto.java
│   │       │   │               │   ├── device
│   │       │   │               │   │   ├── AppAddDto.java
│   │       │   │               │   │   └── DevicePhoneNumberDto.java
│   │       │   │               │   ├── EntitlementAddDto.java
│   │       │   │               │   ├── MessageDto.java
│   │       │   │               │   └── user
│   │       │   │               │       ├── UserAddDto.java
│   │       │   │               │       └── UserUpdateDto.java
│   │       │   │               ├── email
│   │       │   │               │   ├── Email.java
│   │       │   │               │   ├── EmailProperties.java
│   │       │   │               │   ├── EmailService.java
│   │       │   │               │   └── RecipientsType.java
│   │       │   │               ├── error
│   │       │   │               │   └── ErrorCode.java
│   │       │   │               ├── exception
│   │       │   │               │   ├── ApplicationException.java
│   │       │   │               │   └── PermissionException.java
│   │       │   │               ├── GlobalExceptionHandler.java
│   │       │   │               ├── log
│   │       │   │               │   ├── LoggerAudit.java
│   │       │   │               │   └── PerformanceLogger.java
│   │       │   │               ├── permission
│   │       │   │               │   └── management
│   │       │   │               │       ├── ManagementPermissionEntry.java
│   │       │   │               │       └── ManagementPermissionUtils.java
│   │       │   │               ├── procession
│   │       │   │               │   ├── IProcession.java
│   │       │   │               │   └── ProcessionChain.java
│   │       │   │               ├── result
│   │       │   │               │   ├── BadRequestData.java
│   │       │   │               │   ├── Ok.java
│   │       │   │               │   ├── RestResult.java
│   │       │   │               │   ├── ServerException.java
│   │       │   │               │   └── SuccessActionVO.java
│   │       │   │               ├── sms
│   │       │   │               │   ├── Sms.java
│   │       │   │               │   ├── SmsService.java
│   │       │   │               │   └── SmsWebChinese.java
│   │       │   │               ├── testframe
│   │       │   │               │   ├── ConfigReader.java
│   │       │   │               │   ├── Constants.java
│   │       │   │               │   ├── db
│   │       │   │               │   │   ├── DbOperator.java
│   │       │   │               │   │   └── impl
│   │       │   │               │   │       ├── MongoDbOperator.java
│   │       │   │               │   │       └── RedisDbOperator.java
│   │       │   │               │   ├── FieldType.java
│   │       │   │               │   ├── model
│   │       │   │               │   │   ├── BaseSegment.java
│   │       │   │               │   │   ├── DataSegment.java
│   │       │   │               │   │   └── TableSegment.java
│   │       │   │               │   ├── ObjectDescription.java
│   │       │   │               │   ├── Pair.java
│   │       │   │               │   ├── TestFramework.java
│   │       │   │               │   ├── TestFrameworkException.java
│   │       │   │               │   └── utils
│   │       │   │               │       ├── CommonUtils.java
│   │       │   │               │       └── MyDeepEquals.java
│   │       │   │               ├── thread
│   │       │   │               │   └── FixedThreadPool.java
│   │       │   │               ├── utils
│   │       │   │               │   ├── BeanMapperUtils.java
│   │       │   │               │   ├── BufferedImageLuminanceSource.java
│   │       │   │               │   ├── CommonUtils.java
│   │       │   │               │   ├── Constants.java
│   │       │   │               │   ├── CookieUtils.java
│   │       │   │               │   ├── DateUtil.java
│   │       │   │               │   ├── ExcelToJson.java
│   │       │   │               │   ├── HTTPRequestUtils.java
│   │       │   │               │   ├── MetaPropertyUtils.java
│   │       │   │               │   ├── Page.java
│   │       │   │               │   ├── Pair.java
│   │       │   │               │   ├── password
│   │       │   │               │   │   ├── AesUtils.java
│   │       │   │               │   │   ├── Base64Utils.java
│   │       │   │               │   │   ├── Ciphertext.java
│   │       │   │               │   │   ├── HexUtils.java
│   │       │   │               │   │   ├── Main.java
│   │       │   │               │   │   ├── Md5Util.java
│   │       │   │               │   │   └── ShaUtils.java
│   │       │   │               │   ├── PatternUtils.java
│   │       │   │               │   ├── QrCodeCreateUtils.java
│   │       │   │               │   ├── QueryBuilder.java
│   │       │   │               │   ├── ValidateUtils.java
│   │       │   │               │   └── ValueUtils.java
│   │       │   │               ├── verifycode
│   │       │   │               │   ├── VerifyCode.java
│   │       │   │               │   └── VerifyCodeUtil.java
│   │       │   │               ├── vo
│   │       │   │               │   ├── account
│   │       │   │               │   │   ├── AccountVO.java
│   │       │   │               │   │   └── EntitlementVO.java
│   │       │   │               │   ├── AppVO.java
│   │       │   │               │   ├── AssignEntitlementVO.java
│   │       │   │               │   ├── device
│   │       │   │               │   │   ├── DeviceBindingVO.java
│   │       │   │               │   │   └── DeviceQRValueVO.java
│   │       │   │               │   ├── sso
│   │       │   │               │   │   ├── SSOFieldGroupVO.java
│   │       │   │               │   │   ├── SSOFieldVO.java
│   │       │   │               │   │   ├── SSOParserVO.java
│   │       │   │               │   │   └── SSOSelectedVO.java
│   │       │   │               │   └── user
│   │       │   │               │       ├── AppGrantUserVO.java
│   │       │   │               │       ├── UserDetailVO.java
│   │       │   │               │       ├── UserSearchVO.java
│   │       │   │               │       └── UserVO.java
│   │       │   │               └── WebContext.java
│   │       │   └── resources
│   │       │       ├── actionPermissions.yml
│   │       │       ├── logback.xml
│   │       │       ├── mapping.xml
│   │       │       ├── sms.properties
│   │       │       └── test
│   │       │           └── testFramework.yml
│   │       └── test
│   │           └── java
│   │               └── com
│   │                   └── zrkj
│   │                       └── commons
│   │                           ├── permission
│   │                           │   └── test
│   │                           │       ├── CommonTest.java
│   │                           │       ├── ManagementPermissionUtilsTest.java
│   │                           │       ├── testframe
│   │                           │       │   ├── ConfigReaderTest.java
│   │                           │       │   └── utils
│   │                           │       │       └── MyDeepEqualsTest.java
│   │                           │       ├── utils
│   │                           │       │   └── TestObject.java
│   │                           │       └── YamlTest.java
│   │                           └── utils
│   │                               └── DateUtilTest.java
│   ├── inf-dao
│   │   ├── inf-dao.iml
│   │   ├── pom.xml
│   │   └── src
│   │       └── main
│   │           └── java
│   │               └── com
│   │                   └── zrkj
│   │                       └── admin
│   │                           ├── dao
│   │                           │   └── UserDao.java
│   │                           ├── mongo
│   │                           │   ├── AccountApplyRepository.java
│   │                           │   ├── AccountProvisionErrorRepository.java
│   │                           │   ├── AccountProvisionRepository.java
│   │                           │   ├── AccountRepository.java
│   │                           │   ├── AppGrantRepository.java
│   │                           │   ├── AppRepository.java
│   │                           │   ├── DeviceRepository.java
│   │                           │   ├── EntitlementRepository.java
│   │                           │   ├── ImageRepository.java
│   │                           │   ├── MessageRepository.java
│   │                           │   ├── MessageToUserRepository.java
│   │                           │   ├── MetaPropertyRepository.java
│   │                           │   ├── MobileTokenRepository.java
│   │                           │   ├── OrganizationRepository.java
│   │                           │   ├── PasswordPolicyRepository.java
│   │                           │   ├── PasswordRepository.java
│   │                           │   ├── RegionRepository.java
│   │                           │   ├── RoleRepository.java
│   │                           │   ├── SmsRepository.java
│   │                           │   ├── SSOConfigRepository.java
│   │                           │   ├── StrategyRepository.java
│   │                           │   ├── SystemConfigRepository.java
│   │                           │   ├── UserRepository.java
│   │                           │   └── UserRoleRepository.java
│   │                           ├── redis
│   │                           │   ├── IRedisRepository.java
│   │                           │   └── RedisRepository.java
│   │                           └── utils
│   │                               └── PageUtils.java
│   ├── inf-model
│   │   ├── inf-model.iml
│   │   ├── pom.xml
│   │   └── src
│   │       └── main
│   │           └── java
│   │               └── com
│   │                   └── zrkj
│   │                       └── admin
│   │                           └── model
│   │                               ├── annotation
│   │                               │   └── NotRepeat.java
│   │                               ├── base
│   │                               │   └── AbstractBaseObject.java
│   │                               ├── constants
│   │                               │   └── PermissionConstants.java
│   │                               ├── entity
│   │                               │   ├── AccessCenterEntity.java
│   │                               │   ├── account
│   │                               │   │   ├── AccountEntity.java
│   │                               │   │   ├── AccountProvisionEntity.java
│   │                               │   │   └── AccountProvisionErrorEntity.java
│   │                               │   ├── AccountApplyEntity.java
│   │                               │   ├── AppEntity.java
│   │                               │   ├── AppGrantEntity.java
│   │                               │   ├── base
│   │                               │   │   ├── AbstractBaseEntity.java
│   │                               │   │   └── AbstractExtraPropsEntity.java
│   │                               │   ├── DeviceEntity.java
│   │                               │   ├── EntitlementEntity.java
│   │                               │   ├── ImageEntity.java
│   │                               │   ├── MessageEntity.java
│   │                               │   ├── MessageToUserEntity.java
│   │                               │   ├── MetaPropertyEntity.java
│   │                               │   ├── MobileTokenEntity.java
│   │                               │   ├── OrganizationEntity.java
│   │                               │   ├── password
│   │                               │   │   ├── PasswordEntity.java
│   │                               │   │   └── policy
│   │                               │   │       ├── Constrain.java
│   │                               │   │       ├── ExpireConfig.java
│   │                               │   │       ├── Lock.java
│   │                               │   │       ├── PasswordPolicyEntity.java
│   │                               │   │       └── WrongPasswordPolicy.java
│   │                               │   ├── permission
│   │                               │   │   ├── RegionEntity.java
│   │                               │   │   ├── RoleEntity.java
│   │                               │   │   └── UserRoleEntity.java
│   │                               │   ├── SelectableField.java
│   │                               │   ├── SmsEntity.java
│   │                               │   ├── sso
│   │                               │   │   └── SSOConfigEntity.java
│   │                               │   ├── StrategyEntity.java
│   │                               │   ├── SystemConfigEntity.java
│   │                               │   ├── TeamEntity.java
│   │                               │   └── UserEntity.java
│   │                               ├── enums
│   │                               │   ├── AccountProvisionEntityStatusEnum.java
│   │                               │   ├── AccountProvisionEntityTypeEnum.java
│   │                               │   ├── app
│   │                               │   │   └── AppTypeEnum.java
│   │                               │   ├── audit
│   │                               │   │   ├── DeviceTypeEnum.java
│   │                               │   │   ├── OperateTypeEnum.java
│   │                               │   │   └── ResourceTypeEnum.java
│   │                               │   ├── AuthMethodsEnum.java
│   │                               │   ├── EntitlementType.java
│   │                               │   ├── ImageTypeEnum.java
│   │                               │   ├── MetaPropertyIndexStatusEnum.java
│   │                               │   ├── MetaPropertyTypeEnum.java
│   │                               │   ├── NamespaceEnum.java
│   │                               │   ├── OrganizationMentionSearchTypeEnum.java
│   │                               │   ├── OSTypeEnum.java
│   │                               │   ├── password
│   │                               │   │   ├── PasswordExpireNotifyEnum.java
│   │                               │   │   └── PasswordRangeEnum.java
│   │                               │   ├── PermissionEnum.java
│   │                               │   ├── SSOFieldTypeEnum.java
│   │                               │   └── SSOTypeEnum.java
│   │                               └── utils
│   │                                   └── OrganizationInternalVO.java
│   ├── infrastructure.iml
│   ├── inf-service
│   │   ├── inf-service.iml
│   │   ├── pom.xml
│   │   └── src
│   │       └── main
│   │           ├── java
│   │           │   └── com
│   │           │       └── zrkj
│   │           │           └── infrastructure
│   │           │               └── service
│   │           │                   ├── conf
│   │           │                   │   └── ProcessionChainCommonConfigure.java
│   │           │                   ├── EntitlementCommonService.java
│   │           │                   ├── event
│   │           │                   │   ├── email
│   │           │                   │   │   ├── EmailEvent.java
│   │           │                   │   │   └── EmailHandler.java
│   │           │                   │   ├── Event.java
│   │           │                   │   ├── EventBusService.java
│   │           │                   │   ├── EventHandler.java
│   │           │                   │   ├── EventHandlerHelper.java
│   │           │                   │   ├── login
│   │           │                   │   │   ├── LoginEvent.java
│   │           │                   │   │   └── LoginHandler.java
│   │           │                   │   ├── organization
│   │           │                   │   │   ├── OrganizationEvent.java
│   │           │                   │   │   └── OrganizationHandler.java
│   │           │                   │   └── sms
│   │           │                   │       ├── SMSEvent.java
│   │           │                   │       └── SMSHandler.java
│   │           │                   ├── MessageCommonService.java
│   │           │                   ├── PasswordCommonService.java
│   │           │                   ├── PasswordPolicyCommonService.java
│   │           │                   ├── passwordvalidator
│   │           │                   │   ├── BlackList.java
│   │           │                   │   ├── ExpireTime.java
│   │           │                   │   ├── ForceCapital.java
│   │           │                   │   ├── ForceForceLowerCase.java
│   │           │                   │   ├── ForceNumber.java
│   │           │                   │   ├── ForceSpecialLetter.java
│   │           │                   │   ├── MaxDuplicated.java
│   │           │                   │   ├── MaxLength.java
│   │           │                   │   └── MinLength.java
│   │           │                   ├── PropertyValueService.java
│   │           │                   ├── RegionCommonService.java
│   │           │                   ├── sso
│   │           │                   │   ├── impl
│   │           │                   │   │   ├── CasConfigImpl.java
│   │           │                   │   │   ├── configuration
│   │           │                   │   │   │   ├── CasConfiguration.java
│   │           │                   │   │   │   ├── JwtConfiguration.java
│   │           │                   │   │   │   └── OAuthConfiguration.java
│   │           │                   │   │   ├── JwtConfigImpl.java
│   │           │                   │   │   ├── OAuthConfigImpl.java
│   │           │                   │   │   ├── OpenIdConfigImpl.java
│   │           │                   │   │   └── SamlConfigImpl.java
│   │           │                   │   ├── ISSOConfig.java
│   │           │                   │   ├── props
│   │           │                   │   │   ├── impl
│   │           │                   │   │   │   ├── AccountExtraPropertyParserImpl.java
│   │           │                   │   │   │   ├── AccountPropertyParserImpl.java
│   │           │                   │   │   │   ├── DefaultPropertyParserImpl.java
│   │           │                   │   │   │   ├── UserExtraPropertyParserImpl.java
│   │           │                   │   │   │   └── UserPropertyParserImpl.java
│   │           │                   │   │   ├── IPropertyParser.java
│   │           │                   │   │   └── SSOPropertyParserService.java
│   │           │                   │   └── SSOConfigFactory.java
│   │           │                   ├── ticket
│   │           │                   │   ├── PasswordTicket.java
│   │           │                   │   └── PasswordTicketService.java
│   │           │                   ├── UserCommonService.java
│   │           │                   ├── UserRoleCommonService.java
│   │           │                   └── utils
│   │           │                       ├── AppEntityUtils.java
│   │           │                       ├── EntitlementEntityUtils.java
│   │           │                       ├── NamespaceUtils.java
│   │           │                       ├── PropertyValueUtils.java
│   │           │                       └── UserEntityUtils.java
│   │           └── resources
│   │               └── adminConfig.properties
│   └── pom.xml
├── job
│   ├── job.iml
│   ├── job-api
│   │   ├── job-api.iml
│   │   └── pom.xml
│   ├── job-dao
│   │   └── target
│   │       ├── classes
│   │       └── test-classes
│   ├── job-impl
│   │   ├── job-impl.iml
│   │   ├── pom.xml
│   │   └── src
│   │       ├── main
│   │       │   ├── java
│   │       │   │   └── com
│   │       │   │       └── zrkj
│   │       │   │           └── job
│   │       │   │               └── impl
│   │       │   │                   ├── Application.java
│   │       │   │                   ├── Jobs.java
│   │       │   │                   └── Swagger2.java
│   │       │   └── resources
│   │       │       ├── application.properties
│   │       │       ├── application.yml
│   │       │       ├── application-ci.yml
│   │       │       ├── application-dev.yml
│   │       │       ├── application-prod.yml
│   │       │       ├── application-test.yml
│   │       │       ├── application-unit_test.yml
│   │       │       ├── email.properties
│   │       │       ├── jobConfig.properties
│   │       │       └── logback.xml
│   │       └── test
│   │           └── java
│   │               └── com
│   │                   └── zrkj
│   │                       └── job
│   │                           └── impl
│   │                               └── service
│   │                                   └── test
│   │                                       ├── AppJobServiceTest.java
│   │                                       ├── BaseContextTest.java
│   │                                       ├── connector
│   │                                       │   ├── ConnectorJobServiceTest.java
│   │                                       │   └── yaml
│   │                                       │       └── ConnectorJobServiceTest.yml
│   │                                       ├── MetaPropertyJobServiceTest.java
│   │                                       ├── ProvisionJobServiceTest.java
│   │                                       ├── ProvisionMessageJobServiceTest.java
│   │                                       └── yaml
│   │                                           ├── AppJobServiceTest.yml
│   │                                           ├── MetaPropertyJobServiceTest.yml
│   │                                           ├── ProvisionJobServiceTest.yml
│   │                                           └── ProvisionMessageJobServiceTest.yml
│   ├── job-model
│   │   └── target
│   │       ├── classes
│   │       └── test-classes
│   ├── job-service
│   │   ├── job-service.iml
│   │   ├── pom.xml
│   │   └── src
│   │       └── main
│   │           └── java
│   │               └── com
│   │                   └── zrkj
│   │                       └── job
│   │                           └── service
│   │                               ├── AppJobService.java
│   │                               ├── config
│   │                               │   └── JobConfig.java
│   │                               ├── connector
│   │                               │   ├── ConnectorFactory.java
│   │                               │   ├── ConnectorJobService.java
│   │                               │   ├── IConnector.java
│   │                               │   └── impl
│   │                               │       └── GitlabConnector.java
│   │                               ├── MessageJobService.java
│   │                               ├── MetaPropertyJobService.java
│   │                               ├── ProvisionJobService.java
│   │                               └── ProvisionMessageJobService.java
│   ├── job-web
│   │   ├── job-web.iml
│   │   ├── pom.xml
│   │   └── src
│   │       └── main
│   │           ├── java
│   │           │   └── com
│   │           │       └── zrkj
│   │           │           └── admin
│   │           │               └── web
│   │           │                   ├── annotation
│   │           │                   │   └── Swagger2.java
│   │           │                   └── WebApplication.java
│   │           └── resources
│   │               ├── application.properties
│   │               ├── application.yml
│   │               ├── application-dev.yml
│   │               ├── application-prod.yml
│   │               ├── application-test.yml
│   │               └── logback.xml
│   ├── pom.xml
│   ├── README.md
│   └── root-dependency
│       ├── root-dependency.iml
│       └── target
│           ├── maven-archiver
│           └── root-dependency-0.0.1-SNAPSHOT.jar
├── microservice
│   ├── microservice.iml
│   ├── microservice-api
│   │   ├── microservice-api.iml
│   │   ├── pom.xml
│   │   └── src
│   │       └── main
│   │           └── java
│   │               └── com
│   │                   └── zrkj
│   │                       └── microservice
│   │                           └── api
│   │                               ├── dto
│   │                               │   ├── BindFacilityDto.java
│   │                               │   ├── DeviceBindingDto.java
│   │                               │   ├── MobileTokenDto.java
│   │                               │   └── TestDto.java
│   │                               ├── IDeviceBinding.java
│   │                               ├── IMobileToken.java
│   │                               ├── ITest.java
│   │                               └── IUser.java
│   ├── microservice-impl
│   │   ├── microservice-impl.iml
│   │   ├── pom.xml
│   │   └── src
│   │       └── main
│   │           ├── java
│   │           │   └── com
│   │           │       └── zrkj
│   │           │           └── microservice
│   │           │               └── impl
│   │           │                   ├── facade
│   │           │                   │   ├── DeviceBindingFacade.java
│   │           │                   │   ├── MobileTokenFacade.java
│   │           │                   │   ├── TestFacade.java
│   │           │                   │   └── UserFacade.java
│   │           │                   ├── MicroserviceApplication.java
│   │           │                   └── Swagger2.java
│   │           └── resources
│   │               ├── application.properties
│   │               ├── application.yml
│   │               ├── application-dev.yml
│   │               ├── application-prod.yml
│   │               ├── application-test.yml
│   │               ├── application-unit_test.yml
│   │               ├── email.properties
│   │               └── logback.xml
│   ├── microservice-service
│   │   ├── microservice-service.iml
│   │   ├── pom.xml
│   │   └── src
│   │       └── main
│   │           └── java
│   │               └── com
│   │                   └── zrkj
│   │                       └── microservice
│   │                           └── service
│   │                               ├── DeviceBindingServcie.java
│   │                               └── MobileTokenServcie.java
│   ├── pom.xml
│   └── README.md
├── pom.xml
├── README.md
└── root
    ├── pom.xml
    ├── README.md
    └── root.iml

# SystemConfigEntity

{
    "key": "accountProps",
    "value": {
        "账户名称": "account.accountName"
    }
}

{
    "key": "userProps",
    "value": {
        "用户名称": "user.userName",
        "邮箱账户": "user.email",
        "手机号": "user.phone"
    }
}

        appGenerate
        ssoConfigGenerate
        accountGenerate
        entitlementGenerate
        passwordGenerate

# MenuServiceTest.yml

1、menu-config对应菜单结构
2、由permission决定是否显示menu
3、子menu显示了隐含了父menu要展示

menus:
  - name: 身份管理
    code: identity
    permissions:
      - null
    list:
      - name: 身份与组织机构
        code: userOrg
        permissions:
          - organization
          - user
      - name: 身份属性
        code: userConfig
        permissions:
          - userConfig
      - name: 组织机构属性
        code: organizationConfig
        permissions:
          - organizationConfig

  - name: 资源管理
    code: resource
    permissions:
      - null
    list:
      - name: 资源配置
        code: app
        permissions:
          - app
      - name: 授权策略
        code: grant
        permissions:
          - grant
  - name: 认证管理
    code: authAdmin
    permissions:
      - null
    list:
      - name: 密码策略
        code: password
        permissions:
          - password
      - name: 认证策略
        code: security
        permissions:
          - security
  - name: IAM管理员
    code: owner
    permissions:
      - owner
  - name: 审计管理
    code: audit
    permissions:
      - audit


# App管理应用

isAdmin 设置成true
region不设置
挂到user上

    "name": "IAM-ADMIN",
    "icon": "IAM-ADMIN",
    "appTypeEnum": "PC",
    "regionId": "15b10cb9-7bbb-432b-8b24-88c192685fa4",
    "label": "IAM-ADMIN",
    "isEnable": true,
    "isDelete": false,
    "isAdmin": true,
    "version": 0

        orgGenerate
        passwordPolicyGenerate
        systemConfigGenerate
        ssoConfigGenerate
        metaPropertyGenerate
        userGenerate
        System.out
        regionGenerate
        roleGenerate
        urGenerate
        appGenerate
        ssoConfigGenerate
        accountGenerate
        entitlementGenerate
        passwordGenerate

{
    "appId": "管理端Appid",
    "type": "jwt",
    "config": {
        "service": "http://localhost:8081/jwt/jwtLogin"
    }
}
port 8001
JwtConfiguration.SERVICE


# config 外部配置文件
SSOconfig

data-generate需要能配置sample的单点登录地址
要加入webseal的SSOConfigEntity
{
    "_id": "8d6e3c23-6ebe-4085-966e-a60e13701c35",
    "_class": "com.zrkj.admin.model.entity.sso.SSOConfigEntity",
    "appId": "139d05da-4e57-4c20-800e-fb1db0cfb6ab",
    "type": "webseal",
    "config": {
        "attributes": [
            "webseal-userName=user.userName",
            "webseal-email=user.email",
            "webseal-xxx=user.extraProps.idNumber"
        ],
        "sp": "https://wastest.iam.cnpc:8443/test-sp/ssologinnew.jsp",
        "user": "account.accountName"
    },
    "createdDate": ISODate('2018-02-24T12:43:02.853Z'),
    "lastModifiedDate": ISODate('2018-02-24T13:54:08.021Z'),
    "version": 3
}
        orgGenerate
        passwordPolicyGenerate
        systemConfigGenerate
        metaPropertyGenerate
        userGenerate
        System.out
        regionGenerate
        roleGenerate
        urGenerate
        appGenerate
        ssoConfigGenerate
        accountGenerate
        entitlementGenerate
        passwordGenerate

# china-owner有所有权限

{"config":{"service":"http://localhost:7070/sso-cas-sample/casLogin","attributes":["用户名=user.userName","账户名=account.accountName","账户扩展属性地址=account.extraProps.address","用户扩展属性身份证=user.extraProps.idNumber"],"user":"user.userName"},"createdDate":1519804462115,"id":"e3f99157-a9d6-428e-9752-b0142a9848b7","lastModifiedDate":1519804462115,"type":"cas","version":0}"
{"config":{"mapping":["UN=user.userName","EM=user.email","AB=ba","SE=user.extraProps.firstName","AN=account.accountName","HO=account.extraProps.firstName"],"service":"http://localhost:7070/jwt/jwtLogin","attributes":["用户名=user.userName","账户名=account.accountName","账户扩展属性地址=account.extraProps.address","用户扩展属性身份证=user.extraProps.idNumber"],"user":"user.sdda"},"createdDate":1519804462121,"id":"747d0b4e-92d7-446a-9890-e6697cd77b2b","lastModifiedDate":1519804462121,"type":"jwt","version":0}"
{"config":{"mapping":["UN=user.userName","EM=user.email","AB=ba","SE=user.extraProps.firstName","AN=account.accountName","HO=account.extraProps.firstName"],"service":"http://localhost:7070/oauth/oauthLogin","user":"user.sdda"},"createdDate":1519804462123,"id":"bed11447-b39c-433e-b35f-668901c1da03","lastModifiedDate":1519804462123,"type":"oauth","version":0}"
{"config":{"service":"http://localhost:7070/spring-security-saml2-sample/saml/SSO","attribute":["userNameAttr=user.userName","accountNameAttr=account.accountName","accountAddressAttr=account.extraProps.address","userIdNumberAttr=user.extraProps.idNumber"],"user":"user.userName","AudienceURI":"zrkjSP"},"createdDate":1519804462125,"id":"b516982f-53b5-4c18-bdfa-c97bc8857846","lastModifiedDate":1519804462125,"type":"saml2","version":0}"
{"config":{"service":"http://localhost:7070/jwt/jwtLogin"},"createdDate":1519804462126,"id":"eeef8931-f7c1-439b-8e22-7d1b07b35cb6","lastModifiedDate":1519804462126,"type":"jwt","version":0}"
{"config":{"service":"https://wastest.iam.cnpc:7070/test-sp/ssologinnew.jsp","attributes":["webseal-userName=user.userName","webseal-email=user.email","webseal-xxx=user.extraProps.idNumber"],"user":"account.accountName"},"createdDate":1519804462127,"id":"98f39bd4-170d-43dd-a6d9-8938450c9c66","lastModifiedDate":1519804462127,"type":"webseal","version":0}"


"config":{
    "service":"http://localhost:7070/sso-cas-sample/casLogin",
    "attributes":[
      "用户名=user.userName",
      "账户名=account.accountName",
      "账户扩展属性地址=account.extraProps.address",
      "用户扩展属性身份证=user.extraProps.idNumber"
    ],
    "user":"user.userName"
  }


config:{"service":"http://localhost:7070/sso-cas-sample/casLogin","attributes":["用户名=user.userName","账户名=account.accountName","账户扩展属性地址=account.extraProps.address","用户扩展属性身份证=user.extraProps.idNumber"],"user":"user.userName"}


config:
    service:http://localhost:7070/sso-cas-sample/casLogin
    attributes:
      - 用户名=user.userName
      - 账户名=account.accountName
      - 账户扩展属性地址=account.extraProps.address
      - 用户扩展属性身份证=user.extraProps.idNumber
    user:user.userName

    CASConfigMap
    JWTConfigMap
    OAuthConfigMap
    SamConfigMap
    IAMConfigMap
    WebSealConfigMap

{"cas":{"service":"http://localhost:7070/sso-cas-sample/casLogin","attributes":["用户名=user.userName","账户名=account.accountName","账户扩展属性地址=account.extraProps.address","用户扩展属性身份证=user.extraProps.idNumber"],"user":"user.userName"},"iam":{"service":"http://localhost:7070/jwt/jwtLogin"},"jwt":{"service":"http://localhost:7070/jwt/jwtLogin","attributes":["用户名=user.userName","账户名=account.accountName","账户扩展属性地址=account.extraProps.address","用户扩展属性身份证=user.extraProps.idNumber"],"user":"user.sdda"},"webSeal":{"service":"https://wastest.iam.cnpc:7070/test-sp/ssologinnew.jsp","attributes":["webseal-userName=user.userName","webseal-email=user.email","webseal-xxx=user.extraProps.idNumber"],"user":"account.accountName"},"oauth":{"service":"http://localhost:7070/oauth/oauthLogin","attributes":["UN=user.userName","EM=user.email","AB=ba","SE=user.extraProps.firstName","AN=account.accountName","HO=account.extraProps.firstName"],"user":"user.sdda"},"sam":{"service":"http://localhost:7070/spring-security-saml2-sample/saml/SSO","attributes":["userNameAttr=user.userName","accountNameAttr=account.accountName","accountAddressAttr=account.extraProps.address","userIdNumberAttr=user.extraProps.idNumber"],"user":"user.userName","AudienceURI":"zrkjSP"}}

{
  "cas":{
    "service":"http://localhost:7070/sso-cas-sample/casLogin",
    "attributes":[
      "用户名=user.userName",
      "账户名=account.accountName",
      "账户扩展属性地址=account.extraProps.address",
      "用户扩展属性身份证=user.extraProps.idNumber"
    ],
    "user":"user.userName"
  },
  "iam":{
    "service":"http://localhost:7070/jwt/jwtLogin"
  },
  "jwt":{
    "service":"http://localhost:7070/jwt/jwtLogin",
    "attributes":[
      "用户名=user.userName",
      "账户名=account.accountName",
      "账户扩展属性地址=account.extraProps.address",
      "用户扩展属性身份证=user.extraProps.idNumber"
    ],
    "user":"user.sdda"
  },
  "webSeal":{
    "service":"https://wastest.iam.cnpc:7070/test-sp/ssologinnew.jsp",
    "attributes":[
      "webseal-userName=user.userName",
      "webseal-email=user.email",
      "webseal-xxx=user.extraProps.idNumber"
    ],
    "user":"account.accountName"
  },
  "oauth":{
    "service":"http://localhost:7070/oauth/oauthLogin",
    "attributes":[
      "UN=user.userName",
      "EM=user.email",
      "AB=ba",
      "SE=user.extraProps.firstName",
      "AN=account.accountName",
      "HO=account.extraProps.firstName"
    ],
    "user":"user.sdda"
  },
  "sam":{
    "service":"http://localhost:7070/spring-security-saml2-sample/saml/SSO",
    "attributes":[
      "userNameAttr=user.userName",
      "accountNameAttr=account.accountName",
      "accountAddressAttr=account.extraProps.address",
      "userIdNumberAttr=user.extraProps.idNumber"
    ],
    "user":"user.userName",
    "AudienceURI":"zrkjSP"
  }
}







# 毕业设计
D:/Users/zrkj08/IdeaProjects/spring-boot/SpringBoot+VusJS
D:/Users/zrkj08/IdeaProjects/learningvuejs

# DWSurvey
public class AbstractBaseEntity {

    @Indexed
    @CreatedDate
    private Date createdDate;

    @Indexed
    @LastModifiedDate
    private Date lastModifiedDate;
    @Version
    private Long version = null;

    @Id
    private String id = UUID.randomUUID().toString();
}

改包名
改前端页面
使用thymlead
使用Vue

描述前期为毕业设计工作你做了什么准备
完成情况如何
如何查找相关资料
如何提高编程开发能力
如何做需求分析
如何做系统结构设计
如何进行数据库设计

Beginning Spring Boot 2.pdf
    这个有登录
Mastering Spring MVC 4.pdf
    这个有页面一般
Pivotal Certified Professional Spring Developer Exam.pdf

完成情况：
  1.完成了系统需求分析部分的工作，大致分为注册登录，文件上传，视频在线播放，在线出题做题，在线考试。查询整理了相关计算机专业学习资料，大致分为SpringBoot，Vue.js，MongoDB，视频在线播放，问卷调查。

  2.模仿DWSurvey，完成了出题模块的数据库实体模型设计。模仿anyvideo，完成视频模块的数据库实体模型设计。模仿cms，完成管理模块的数据库实体模型设计。

  3.确定本系统主要是为了方便学生上网学习，同时教师和管理员也可以将进入系统进行查询修改以及检测，操作方便，简单易懂。

  4.利用这段时间基本完成了系统中需求分析，数据库设计，登录注册功能，多条件组合查询等模块的实现工作

存在的问题：

  1.系统的文件上传功能还存在问题，正在查资料进行调试

  2.SpringBoot+MongoDB的配置文件基本整理完毕，但是jsp页面跳转controller存在问题，目前正查找网上资料寻找原因

  3.代码比较冗余，所以在后期调试中需要重读代码，找出可以优化的地方。

  4.项目不能支持高并发访问，对于这方面的知识还比较欠缺，需要更多的学习。

总结:

   近期的进度有点落后，要在保质保量的情况下，将进度提升起来。最后，感谢张老师在百忙之中对我们的督促和教导。

Pro Spring boot
272

Web Development with Bootstrap and Vue.JS
61暂停
263

Grokking Algorithms
127

3 - 7没看
6 4:007
8-2 4:05
5-4 00:45 select
5-6 00:45 datagrid
疑问，分页，精准查询，下拉联动

邮政
1169090319220

解锁scotte hr用户
授权，表导入导出
exp/imp
expdb/impdb

Vue JS 2 - The Complete Guide (incl. Vuex)
21

【编程】《跟上 Java 8 - 从入门到实践》
28:13

微信上看到的要看的书
测试面试题的sql语句，在GitHub上
男为1，女为0
undo 'git commit --amend'
git reflog
git reset --soft ${提交的id}
查看京东售后

先序：abdgcefh
中序：dgbaechf

先序：abdgcefh -> a bdgcefh
中序：dgbaechf -> dgb a echf

先序：bdgcefh -> b dgcefh
中序：dgb -> dg b

先序：gcefh -> g cefh
中序：dg -> d g

先序：cefh -> c efh
中序：echf -> e c hf

先序：fh ->  fh
中序：hf ->  h f
                    a
            b               c
        d               e       f
            g               h

后序：gdbehfca
中序：dgbaechf

后序：gdbehfca -> gdbehfc a
中序：dgbaechf -> dgb a echf

后序：gdbehfca -> gdbehfc a
中序：dgbaechf -> dgb a echf

后序：gdbehfca -> gdbehf c
中序：dgbaechf -> dgb a |  e c hf

后序：gdbehfca -> gdbeh f
中序：dgbaechf -> dgb a |  e c | hf

                    a
            b               c
        d               e       f
            g               h
Pivotal Certified Spring Enterprise Integration Specialist Exam
129

实习生 （实习）
知人科技有限公司 IT服务/系统集成

使用visual paradigm画序列图，流程图，提升了对软件流程的认知；
使用Spring Boot向mongoDB中填充数据，模拟生成的一百万数据符合开发测试需求。编写简单单元测试，完善代码覆盖率。
成功申请Apple Id开发者公司账号，向苹果应用商店推送app。

照着文思海辉的要求写一个投递
会jquery，ajax
照着久远银海的要求写一个投递
jQuery
32
EasyUI
MySql
Redis
Axure
PowerDesigner
Rational Rose
Together
多线程编程
这些要写进去    JS、JQuery、HTML、CSS、HTML5    Linux服务器操作系统
JVM性能调优

Spring Cloud
ElasticSearch


存在普遍的问题我在这给大家提出，希望所有同学按要求写。
一、论文中所有语句不能有语法错误，内容必须多读读，不能有不合理的地方；
二、注意文章排版，必须按学校要求进行；
三、“系统详细设计实现”部分应当对每个模块的主要功能进行详细描述，这部分在论文中占主要部分，篇幅不低于12页（最好15页以上），每部分的描述主要从五个方面进行：1、本功能的文字描述（至少1个段落）；2、设计流程图；3、设计运行截图；4、核心代码（最核心的12-15行代码）；5、如需要，说明设计的亮点或特点；
四、“系统测试”部分可能测试用例不当，应该有关与系统运行中相关操作的测试，比如使用某些输入数据验证输出结果正确否？
五、“总结”部分不能写成 心得体会！应当是你对本次设计过程的总结。比如，你的设计过程、如何设计主要的部分、那些部分设计的好、那些部分没有完成、对未完成部分的计划、今后有机会如何改进设计等等。
六、“参考文献”不能都是教材参考书，必须有相关的外文资料（3篇）、有与题目相关的期刊发表的设计文章（6篇）（我给你的参考文献中有部分），格式必须按学校要求排版。

[1]王爱华,汪琼.精品课程与国外开放课程共享利用的对比研究[J];中国远程教育;2010年06期
[2]胥旭,徐恩芹,张桂娟.国内精品课程与MITOCW网络教学资源的对比分析[J];中国教育信息化;2012年05期
[3]王艳梅.精品课程的网络资源建设研究与实践[D];上海师范大学;2012年
[4]刘乃琦,王冲.《JSP应用开发与实践》;人民邮电出版社;2016年
[5]朱珍,张琳霞.《PHP网站开发技术》;电子工业出版社;2014.8

启动mysql, redis,关360

Vim ctrl + i
Vim replace
测试
写视频
管理
试卷
=================================
课件信息的管理 2. 不同的文件夹
=================================
file:///D:/zrkj08/pdf/Vue.js-2-and-Bootstrap-4-Web-Development.pdf

视频点播模块 3.
=================
作业管理模块 4. homework文件夹，姓名和学号, 还要有一个学习资料，为共有文件夹

在线测试模块 5. 
=================
系统管理模块 6. 
=================
留言板       7. 


Spring Boot 1.5.9.RELEASE

Beginning Progressive Web App Development
228

servuey collection design user

name, title, queue

http://kaiyuan.hudong.com/download/
登录改变可以用这个
Beginning Spring Boot 2
1. 注册登陆模块。
2. 课件管理模块：能够将教学资源上传并利于教师浏览使用，给教师提供了一个资源存放和使用的平台，同时也是学生的学习平台。
3. 视频点播模块：客户终端能够在远程或局域网里随意自由地点播各种流媒体格式的视音频节目。
4. 作业管理模块：实现教师布置作业、学生上交作业。
5. 在线测试模块：实现教师出题、学生在线考试。
6. 系统管理模块。
名词：
    老师
    教师
    PowerPoint课件
    代码
    同学
    课程
    作业要求
    布置
    完成
    题目要求
    编辑器
    文件
    答案
    附件
    成绩
    评语
    课本
    重点
动词：
    上课
    讲解
    索要
    分布
    登录
    压缩
    发布
    看到
    打开
    提交
    录入
    批改
    预习

UserEnttiy
    SurveyStatusEntity
SurveyDirectoryEntity
SurveyAnswerEntity -> survey_id对应SurveyDirectoryEntity

QuestionEntity -> belong_id对应SurveyDirectoryEntity
QChoiceEntity
    QMatrixBlankEntity
QCheckBoxEntity

ChoiceEntity
BlankEntity
CheckBoxEntity -> belong_answer_id对应t_survey_answer

    SELECT
      e1.empno as empno,
      e1.ename as ename,
      e1.hiredate as hiredate,
      rowno
    FROM (
      SELECT
        e.empno as empno,
        e.ename as ename,
        e.hiredate as hiredate,
        ROWNUM rowno
      FROM (
        select
          t.empno as empno,
          t.ename as ename,
          t.hiredate as hiredate
        from emp t
        ORDER BY ename asc ) e
      where 1=1
      and
      rownum <= 13) e1
     WHERE 1=1
    and
      rowno >= 2;
