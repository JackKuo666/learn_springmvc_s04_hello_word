# learn spring mvc hello word
技术：
```
Spring
SpringMVC
SpringSecurity
html
js
```

## 启动

### 1.下载tomcat: [9.0.65](https://mirrors.cnnic.cn/apache/tomcat/tomcat-9/v9.0.65/bin/)

### 2.配置tomcat

然后配置中文：

```
tomcat 虚拟机选项: -Dfile.encoding=UTF-8
```

配置URL:
```
http://localhost:8011/mvc/tmp/test111
```
配置【部署-应用程序上下文】
```
应用程序上下文: /mvc
```
### 3.配置maven
maven版本：3.8.1

maven的.m2/settings.xml文件配置阿里源
```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                          https://maven.apache.org/xsd/settings-1.0.0.xsd">
      
      <mirrors>
    	<mirror>  
      		<id>alimaven</id>  
      		<name>aliyun maven</name>  
      		<url>http://maven.aliyun.com/nexus/content/groups/public/</url>  
      		<mirrorOf>central</mirrorOf>          
    	</mirror>  
      </mirrors>
</settings>
```


### 4.运行
使用idea配置好tomcat,直接运行即可。

- 上传下载文件
- csrf  需要先打开服务，然后将CSRF.html地址（`D:\learn\s04spring_mvc\src\main\webapp\WEB-INF\template\CSRF.html`）质检放入浏览器就可以实现了。

### 参考：

[spring mvc](https://www.yuque.com/qingkongxiaguang/spring/nn91w0) 

[SpringSecurity](https://www.yuque.com/qingkongxiaguang/spring/cdrkgt)
