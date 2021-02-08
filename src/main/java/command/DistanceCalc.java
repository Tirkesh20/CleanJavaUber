package command;

class  DistanceCalc{

    public final static double AVERAGE_RADIUS_OF_EARTH_KM = 6371;
    public int calculateDistanceInKilometer(double clientLat, double clientLng,
                                            double taxiLat, double taxiLng) {

        double latDistance = Math.toRadians(clientLat - taxiLat);
        double lngDistance = Math.toRadians(clientLng - taxiLng);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(clientLat)) * Math.cos(Math.toRadians(taxiLat))
                * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (int) (Math.round(AVERAGE_RADIUS_OF_EARTH_KM * c));
    }


}