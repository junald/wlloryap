/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcl.dbms;

/**
 * EmbeddedConfiguration used for {@link StartServer} and {@link StopServer}.
 */
public interface ServerSetup {

  /**
   * the host to be used.
   * <br>If you want to run the client server examples on two computers,
   * enter the computer name of the one that you want to use as server.
   */
  public String   HOST = "localhost";

  /**
   * the database file to be used by the server.
   */
  public String   FILE = "C:/testdb/mydb.db4o";

  /**
   * the port to be used by the server.
   */
  public int    PORT = 4488;

  /**
   * the user name for access control.
   */
  public String   USER = "admin";

  /**
   * the pasword for access control.
   */
  public String   PASS = "password";
}
