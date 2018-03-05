此项目为ext组 http接口加密暴露 部分

ycgwl http请求加密测试项目
请在 src/main/test/ com.ycgwl.http.secret 指定位置编写测试代码

特别说明
拦截路径
com.ycgwl.rosefinch.module.basedev.server.interceptor.base.AuthInterceptor

  SELECT APP_ID, APP_KEY, APP_NAME, APP_SECRET, 
        TIMEOUT_MILLIS, TIMESTAMP_MINUTES, IP_WHITE_LIST, 
        PRE_1, PRE_2, PRE_3, PRE_4, PRE_5,
        CREATE_TIME, CREATE_USER_CODE, MODIFY_TIME, MODIFY_USER_CODE,
        REMARK, DEL_FLAG FROM T_BASE_APP_INFO T 
        WHERE T.APP_KEY = #{appKey,jdbcType=VARCHAR}       
        
HttpSecretVo 中的 appKey,appSecret为 bdm中 T_BASE_APP_INFO 表中字段
建议 params 通过后台断点,debug面板 JSON.toJSONString(queryPageVo.getParaMap());
右键 copy Value拷贝出来

建议rest接口中的String params通过 Map接受: 如
  /**
     * 外部程序 http查询接口
     * @param params
     * @return
     */
   @RequestMapping("/queryBaseBank.api")
   @ResponseBody
   @SecurityNonCheckRequired
   public ResultEntity queryEmployeeApi(String params){
       try {
           HashMap hashMap = JSON.parseObject(params, HashMap.class);
           Page page = new Page();
           page.setPageNum(1);
           page.setPageSize(Integer.MAX_VALUE);
           Pagination<BaseBankEntity> baseBankEntityPagination = this.baseBankService.queryBaseBank(hashMap, page, null);
           return returnSuccess(baseBankEntityPagination.getList());
       }catch (Exception ex){
           return returnException(ex.getMessage());
       }
   }
   
   
   调用
   <dependency>
   			<groupId>com.ycgwl.base</groupId>
   			<artifactId>http-client-test</artifactId>
   			<version>2.0.0.0</version>
   		</dependency>