package Models.Store;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalTime;

/**
 * CREATED BY mathias @ 16-11-2021 - 13:04
 **/
public class Log {
    private final LocalTime time;
    private HttpServletRequest request;
    private String message;
    private WarnLevel WarnLevel;
    public Log(WarnLevel WarnLevel, HttpServletRequest request, String message) {
        time = LocalTime.now();
        this.request = request;
        this.message = message;
        this.WarnLevel = WarnLevel;
    }

    public Log.WarnLevel getWarnLevel() {
        return WarnLevel;
    }

    public void setWarnLevel(Log.WarnLevel warnLevel) {
        WarnLevel = warnLevel;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRiskLevel(WarnLevel WarnLevel) {
        this.WarnLevel = WarnLevel;
    }

    @Override
    public String toString() {
        switch (WarnLevel) {
            case LOW_RISK:
                return "(INTERNAL WEB LOG) >NOTICE: [@" + time + "] WARNING: [" + WarnLevel + "] MSG: " + message + " REQ: [Session_ID " + request.getRemoteUser() + " - " + request.getRemoteAddr() + "]\n";
            case MED_RISK:
                return "(INTERNAL WEB LOG) >NOTICE: [@" + time + "] WARNING: [" + WarnLevel + "] MSG: " + message + " REQ: [Session_ID " + request.getSession().getId() + " - " + request.getRemoteAddr() + " - " + request.getLocalName() + "]\n";

            case HIGH_RISK:
                return "(INTERNAL WEB LOG) >NOTICE: [@" + time + "] WARNING: [" + WarnLevel + "] MSG: " + message + " REQ: [Session_ID " + request.getSession().getId() + " - " + request.getRemoteAddr() + " - " + request.getLocalName() + " - " + request.getRemoteHost() + "]\n";

            default:
                return "LOG[" + time + "] WARNING: [ NONE ] MSG: " + message + " REQ: [" + request.getSession().getId() + " - " + request.getLocalAddr() + "]";

        }
    }

    public enum WarnLevel {
        LOW_RISK,
        MED_RISK,
        HIGH_RISK
    }


}
