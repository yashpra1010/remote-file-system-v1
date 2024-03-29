package com.remoteFS.client.handler;

import java.io.IOException;

public class UserHandlerClient
{
    private final ServerConnection serverConnection;

    public UserHandlerClient(ServerConnection serverConnection)
    {
        this.serverConnection = serverConnection;
    }

    public boolean sendLoginReq(String username, String password)
    {
        try
        {
            var response = serverConnection.sendRequest("LOGIN " + username.trim() + "," + password.trim());

            return response.equals("true");

        } catch(NullPointerException npe)
        {
            System.out.println("[Client] Server is down!");

            return false;
        } catch(IOException e)
        {
            System.out.println("[Client] Server timeout or Error listing files from server!");

            return false;
        }
    }

    public boolean sendRegisterReq(String username, String password)
    {
        try
        {
            var response = serverConnection.sendRequest("REGISTER " + username.trim() + "," + password.trim());

            return response.equals("true");

        } catch(NullPointerException npe)
        {
            System.out.println("[Client] Server is down!");

            return false;
        } catch(IOException e)
        {
            System.out.println("[Client] Server timeout or Error listing files from server!");

            return false;
        }
    }
}
