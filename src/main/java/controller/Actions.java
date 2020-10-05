package controller;

import javax.servlet.http.HttpServletRequest;

enum Actions {
    SIGNUP {
        {
            this.command = new CmdSignUp();
        }
    },
    LOGIN {
        {
            this.command = new CmdLogin();
        }
    },
    PROFILE {
        {
            this.command = new CmdProfile();
        }
    },
    CREATEAD {
        {
            this.command = new CmdCreateAd();
        }
    },
    EDITUSERS {
        {
            this.command = new CmdEditUsers();
        }
    },
    LISTAD {
        {
            this.command = new CmdListAd();
        }
    },
    HOME {
        {
            this.command = new CmdHome();
        }
    },
    SEARCH {
        {
            this.command = new CmdSearch();
        }
    },
    FOUNDEDADS {
        {
            this.command = new CmdFoundedAds();
        }
    },
    ERROR {
        {
            this.command = new CmdError();
        }
    };

    public Action command;

    static Action defineFrom(HttpServletRequest request) {
        String command = request.getParameter("command");
        if(command==null){
            command="index";
        }
        Action res;
        try {
            res = Actions.valueOf(command.toUpperCase()).command;
        } catch (IllegalArgumentException ex) {
            res = Actions.ERROR.command;
        }
        return res;
    }
}
