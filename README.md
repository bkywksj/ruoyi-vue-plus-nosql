# 框架介绍
移除数据库模块和redis模块和简化一些模块，只保留框架的基本功能，方便无数据库和无redis项目的快速开发。
部署只需要提供一个jar包即可，无需配置数据库和redis。

# 项目结构
``` 
├── ruoyi-admin -- 主模块
├── ruoyi-common -- 工具类及通用代码
├── ruoyi-modules -- 开发模块
├── script -- docker脚本

业务代码在ruoyi-modules中的ruoyi-service模块开发即可。
```

# 更多项目
- [ruoyi-vue-plus-uniapp](https://gitee.com/bkywksj/ruoyi-vue-plus-uniapp)：基于ruoyi-vue-plus全面改造，用于移动端（App及小程序的开发）