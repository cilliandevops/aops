package website.cillian.aops.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author cillian
 * @since 2023-10-30 04:44:39
 */
@Getter
@Setter
@TableName("user")
@ApiModel(value = "User对象", description = "用户表")
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty("密码")
    @TableField("password")
    private String password;

    @ApiModelProperty("姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("电话")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("地址")
    @TableField("address")
    private String address;

    @ApiModelProperty("头像")
    @TableField("avatar")
    private String avatar;
}
