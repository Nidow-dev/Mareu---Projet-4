package elodie.gross.mareu.di;

import java.util.List;

import elodie.gross.mareu.model.Meeting;
import elodie.gross.mareu.service.ApiMeeting;
import elodie.gross.mareu.service.ApiMeetingService;
import elodie.gross.mareu.service.DummyMeetingGenerator;

public class DI {

    private static ApiMeeting service = new ApiMeetingService();

    /**
     * Get an instance on @{@link ApiMeeting}
     * @return
     */
    public static ApiMeeting getApiMeeting() {
        return service;
    }

    /**
     * Get always a new instance on @{@link ApiMeeting}. Useful for tests, so we ensure the context is clean.
     * @return
     */
    public static ApiMeeting getNewInstanceApiMeeting() {
        return new ApiMeetingService();
    }
}

}
