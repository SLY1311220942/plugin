# plugin
## 1.公共组件
> plugin-common

> 该工程主要是搭建web工程需要的一些基本工具和模型，当然这些工具和模型只是在我的体系里有用，其它的体系可能不兼容。

### 1.1.验证码使用

```java
//jpg
response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache");
response.setDateHeader("Expires", 0);
response.setContentType("image/jpg");
/**
 * jgp格式验证码 宽，高，位数。
 */
BaseCaptcha captcha = new SpecCaptcha(146, 33, 4);
// 输出
captcha.out(response.getOutputStream());
HttpSession session = request.getSession(true);
session.setAttribute(CommonConstant.LOGIN_VALIDATECODE_KEY, captcha.text().toLowerCase());
```

```java
//gif
response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache");
response.setDateHeader("Expires", 0);
response.setContentType("image/gif");
/**
 * gif格式动画验证码 宽，高，位数。
 */
BaseCaptcha captcha = new GifCaptcha(146, 33, 4);
// 输出
captcha.out(response.getOutputStream());
HttpSession session = request.getSession(true);
session.setAttribute(CommonConstant.LOGIN_VALIDATECODE_KEY, captcha.text().toLowerCase());
```

## 2.反重复提交插件
> plugin-anti-duplicate-commit

> 该工程依赖了plugin-common，这个工程主要是为了防止重复提交。


## 3.xss过滤器
> plugin-xss-filter

> 该工程是为了防止xss攻击，对请求数据做了过滤。