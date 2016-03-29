# Maven
An Android gradle use Maven local repository

## 工程说明：
1. 该工程是一个在android studio的gradle中maven的测试工程
2. 主要是为了测试maven企业私服环境是否搭建成功
3. 测试android studio 使用本地私服上传下载maven控件
   build.gradle 中 compile 'groupId:artifactId-version' 形式

### 环境搭建

3. maven私服使用Nexus oss 管理，关于Nexus oss 搭建请参照
[建立企业内部Maven服务器并使用Android Studio发布公共项目](http://www.linuxidc.com/Linux/2015-06/118878.htm)
[nexus-2.12.0安装与部署](http://blog.csdn.net/yccn214/article/details/50527490)
4. 本工程在linux 环境下部署成功

### 关于android studio 上传 maven 私服 
上面搭建成功后，就可以使用android studio来管理了。
具体的可以参照工程中common.gradle , user.properties 以及app/gradle.properties 中的配置
