# cloud-config 配置中心

基于spring cloud开发云平台

# 配置读取规则
/{application}-{profile}.yml
/读取的配置文件名-环境配置项 （默认为master分支）
如：http://localhost:5001/config-application-dev.yml
/{application}/{profile}[/{label}]
/读取的配置文件名/环境配置项/分支名
如：http://localhost:5001/config-application/dev/master
/{label}/{application}-{profile}.yml
/分支名/读取的配置文件名/环境配置项
如：http://localhost:5001/master/config-application-dev.yml