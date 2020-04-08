package elodie.gross.mareu.di;

import elodie.gross.mareu.service.ApiMeetingService;
import elodie.gross.mareu.service.FakeApiMeeting;

public class DI {

    private static FakeApiMeeting service = new ApiMeetingService();

    /**
     * Get an instance on @{@link FakeApiMeeting}
     * @return
     */
    public static FakeApiMeeting getApiMeeting() {
        return service;
    }

    /**
     * Get always a new instance on @{@link FakeApiMeeting}. Useful for tests, so we ensure the context is clean.
     * @return
     */
    public static FakeApiMeeting getNewInstanceApiMeeting() {
        return new ApiMeetingService();
    }
}
