package first.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;

import lombok.Data;

@Data // 编译的时候自动加上get、set方法
public class User {

	// 主键
	private Long id;

	// 姓名
	private String name;

	// 年龄
	private Integer age;

	// 邮件
	private String email;

	// 直属上级
	private Long managerId;

	// 创建时间
	private LocalDateTime createTime;

//	// ①transient标识该参数不参与序列化过程
//	private transient String remark;

//	// ②静态属性
//	private static String remark;
//	
//	public static String getRemark() {
//		return remark;
//	}
//
//	public static void setRemark(String remark) {
//		User.remark = remark;
//	}

	@TableField(exist = false)
	private String remark;
}
