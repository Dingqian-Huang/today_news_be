package com.david.admin.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdChannel implements Serializable {
    @Id
    Integer id;
    String name;
    String description;
    Boolean isDefault;
    Boolean status;
    Integer ord;
    Date createdTime;
}
