# android studio project use maven
An Android gradle use Maven local repository

## 工程说明：
1. 该工程是一个在android studio的gradle中maven的测试工程；
2. 主要是为了测试maven企业私服环境是否搭建成功；
3. 测试android studio使用本地私服上传下载maven控件；
   build.gradle以compile 'groupId:artifactId:version' 形式依赖；
4. 虽然在本程序中，utillibrary是以Module的形式与app Module放在同一个工程下的，
但是在app Module中并不是以compile project形式引入的，而是以说明3中的方式引入的。

### 环境搭建

1. maven私服使用Nexus oss 管理，关于Nexus oss 搭建请参照
[建立企业内部Maven服务器并使用Android Studio发布公共项目](http://www.linuxidc.com/Linux/2015-06/118878.htm) 以及
[nexus-2.12.0安装与部署](http://blog.csdn.net/yccn214/article/details/50527490)；
2. 本工程在linux 环境下部署成功。

### 关于android studio 上传 maven 私服 
上面搭建成功后，就可以使用android studio来管理了。
具体的可以参照工程中common.gradle , user.properties 以及utillibrary/gradle.properties 中的配置
配置注意点：

1. common.gradle 中

   + 需要申明apply plugin: 'maven' 为maven 不然找不到mavenDeployer函数
   + user.properties 里面对应的 repository.url 必须与 pom.project 中申明的 version(在各个工程配置里的gradle.properties文件)匹配。release必须为release的url, snapshots 必须为 snapshots的url,所以两个文件中，这个地方需要匹配。不然传不上去。必须匹配，不能用Group 的url，因为Group的一般只配置view只读权限，只提供预览release和snapshots里面的库，并且可以提供下载(包括中央工程的代理)。

2. maven 的 settings.xml 中

   + mirror、profile、activeProfile、server 的配置
