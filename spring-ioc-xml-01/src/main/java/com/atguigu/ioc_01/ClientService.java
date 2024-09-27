package com.atguigu.ioc_01;


//静态工厂 实例化对象
public class ClientService {
  private static ClientService clientService = new ClientService();
  private ClientService() {}

  public static ClientService createInstance() {
    return clientService;
  }
}