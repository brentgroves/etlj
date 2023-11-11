package com.mobex.etl_lib;  
// https://razorsql.com/articles/ms_sql_server_jdbc_connect.html

public final class CribmasterFactory {
  private CribmasterFactory() {

  }
  public static EtlTest createCribmaster() {
    return new CribmasterImpl();
  } 
}