# xu-engineering

#### 介绍
工程化,打包项目

#### 运行一个jar
- 如果配置了`MANIFEST.MF`
`java -jar jar-1.0.jar`

- 如果没有配置`MANIFEST.MF`
`java -cp jar-1.0.jar name.xu.App`


#### 目录架构
- package-assembly-simplest  
    使用 assembly 插件进行打包,打包成一个可运行的jar
- package-assembly  
    使用 assembly 插件进行打包,重写jar里面的class
# 使用 assembly 插件进行打包 
修改 pom 文件中的 descriptor 来改变打包方式 
    - assemblies
        原本提供的四种打包
    - assemblies/xu
        自己修改的
