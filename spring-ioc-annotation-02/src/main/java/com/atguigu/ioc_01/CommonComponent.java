package com.atguigu.ioc_01;

import org.springframework.stereotype.Component;

/**
 * 功能：
 * 日期：2024/7/816:39
 */

//类名首字母小写就是默认 bean 的 id。例如：CommonComponent 类对应的 bean 的 id 就是 commonComponent
//也可以使用value属性指定：@Controller(value = "zhiding")
@Component
public class CommonComponent {
}
