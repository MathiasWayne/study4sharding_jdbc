package com.sungrow.shardingjdbc_demo.dao;
import	java.math.BigDecimal;
import java.util.List;
import java.util.Map;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface OrderDao {

    /**插入数据*/
    @Insert("insert into t_order(price,user_id,status) value (#{price},#{userId},#{status})")
    public int insert(@Param("price")BigDecimal price, @Param("userId")Long userId,@Param("status")String status);

    /**根据id列表查询数据*/
    @Select("<script>"+
            "select * from t_order t where t.order_id in"+
            "<foreach collection='ids' item='id' open='(' close=')' separator=','>"+
                "#{id}"+
            "</foreach>"+
            "</script>")
   public List<Map<String,String>> selectOrderByIds(@Param("ids") List<Long> ids);


}
