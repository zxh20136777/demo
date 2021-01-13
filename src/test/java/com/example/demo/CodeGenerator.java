package com.example.demo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.IFileCreate;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author anson
 * @Date 2021/01/04 14:43
 */
public class CodeGenerator {

  /**
   * 数据源配置
   */
  public static class DataSourceProperties {

    public static final String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/pinyougoudb?characterEncoding=UTF-8&allowMultiQueries=true";
    public static final String username = "test";
    public static final String password = "1233";
  }

  /**
   * 包配置
   */
  public static class PackageProperties {

    //多模块中的模块
    public static final String module = "";
    //指定生成根目录
    public static final String parent = "com.example.demo";
    //controller目录
    public static final String controller = "controller.generate";
    //service目录
    public static final String service = "service";
    //impl目录
    public static final String serviceImpl = "service.impl";
    //实体目录
    public static final String entity = "entity";
    //dao目录
    public static final String dao = "mapper.generate";
  }

  /**
   * 其它属性配置
   */
  public static class CustomProperties {

    //注释作者请按此格式编写
    public static final String author = "Anson";
    //需要生成的表配置，可以一次生成多个
//     public static final String[] tables = {"oauth_access_token","oauth_approvals","oauth_client_details","oauth_client_token","oauth_code","oauth_refresh_token","uc_account","uc_account_app_relation","uc_account_archive","uc_account_contract_relation","uc_app","uc_category","uc_contract","uc_contract_history","uc_data","uc_group","uc_group_category_relation","uc_invite_code","uc_menu","uc_resource","uc_role","uc_role_menu_relation","uc_role_resource_relation","uc_table_modify_log","uc_user","uc_user_group_relation","uc_user_login_log","uc_user_role_relatio"};
    public static final String[] tables = {"uc_user"};
  }

  public static void main(String[] args) {
    // 代码生成器
    AutoGenerator mpg = new AutoGenerator();

    // 全局配置
    GlobalConfig gc = new GlobalConfig();
    String projectPath = System.getProperty("user.dir");
    StringBuilder ouput_dir = new StringBuilder();
    ouput_dir.append(projectPath).append(File.separator).append(PackageProperties.module)
        .append("/src/main/java");
    gc.setOutputDir(ouput_dir.toString());
    gc.setAuthor(CustomProperties.author);
    gc.setBaseResultMap(true);
    gc.setBaseColumnList(true);
    gc.setOpen(false);
    //实体属性 Swagger2 注解
    gc.setSwagger2(true);
    mpg.setGlobalConfig(gc);

    // dataSource配置
    DataSourceConfig dsc = new DataSourceConfig();
    dsc.setDbType(DbType.MYSQL);
    dsc.setUrl(DataSourceProperties.jdbcUrl);
    dsc.setDriverName("com.mysql.cj.jdbc.Driver");
    dsc.setUsername(DataSourceProperties.username);
    dsc.setPassword(DataSourceProperties.password);
    mpg.setDataSource(dsc);

    // package配置
    PackageConfig pc = new PackageConfig();

    pc.setParent(PackageProperties.parent);
    pc.setController(PackageProperties.controller);
    pc.setService(PackageProperties.service);
    pc.setServiceImpl(PackageProperties.serviceImpl);
    pc.setEntity(PackageProperties.entity);
    pc.setMapper(PackageProperties.dao);
    mpg.setPackageInfo(pc);

    // 自定义配置
    InjectionConfig cfg = new InjectionConfig() {
      @Override
      public void initMap() {
        /* ... */
      }
    };

    // 如果模板引擎是 freemarker
    String templatePath = "/templates/mapper.xml.ftl";
    // 自定义输出配置
    List<FileOutConfig> focList = new ArrayList<>();

    // 自定义配置会被优先输出
    focList.add(new FileOutConfig(templatePath) {

      @Override
      public String outputFile(TableInfo tableInfo) {
        // 自定义输入文件名称
        StringBuilder xml_output = new StringBuilder(projectPath);
        xml_output.append(File.separator).append(PackageProperties.module)
            .append("/src/main/resources/sql/default/")
            .append(tableInfo.getEntityName()).append("Mapper")
            .append(StringPool.DOT_XML);
        return xml_output.toString();
      }
    });

    cfg.setFileOutConfigList(focList);

    cfg.setFileCreate(new IFileCreate() {
      @Override
      public boolean isCreate(ConfigBuilder configBuilder, FileType fileType,
          String filePath) {
        // 判断自定义文件夹是否需要创建
        checkDir(filePath);
        File file = new File(filePath);
        if (file.exists()) {
          //覆盖实体
          if (fileType == FileType.ENTITY) {
            return true;
          }
          //覆盖xml
          if (fileType == FileType.OTHER) {
            return true;
          }
          return false;
        } else {
          //不存在的文件都需要创建
          return true;
        }
      }
    });

    mpg.setCfg(cfg);
    // 配置模板
    TemplateConfig templateConfig = new TemplateConfig();
    templateConfig.setXml(null);
//    templateConfig.setController(null);
//    templateConfig.setService(null);
    mpg.setTemplate(templateConfig);

    // 策略配置
    StrategyConfig strategy = new StrategyConfig();
    strategy.setNaming(NamingStrategy.underline_to_camel);
    strategy.setColumnNaming(NamingStrategy.underline_to_camel);
    strategy.setEntityLombokModel(false);
    strategy.setLogicDeleteFieldName("deleted");
    strategy.setRestControllerStyle(false);
    // 公共父类
    // 写于父类中的公共字段
//        strategy.setSuperEntityColumns("id");
    strategy.setInclude(CustomProperties.tables);
    strategy.setControllerMappingHyphenStyle(true);
    strategy.setTablePrefix("");
    mpg.setStrategy(strategy);
    mpg.setTemplateEngine(new FreemarkerTemplateEngine());
    mpg.execute();
  }

}