package com.atguigu.ioc_01;


//实例工厂 实例化对象
public class DefaultServiceLocator {

  private static ClientServiceImpl clientService= new ClientServiceImpl();

  public ClientServiceImpl createClientServiceInstance() {
    return clientService;
  }
}