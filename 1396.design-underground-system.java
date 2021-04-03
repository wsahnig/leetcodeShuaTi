/*
 * @lc app=leetcode id=1396 lang=java
 *
 * [1396] Design Underground System
 */

// @lc code=start
class UndergroundSystem {
    private Map<Integer, CheckInInfo> checkIn;
    private Map<String, HashMap<String, StationCountInfo>> totalTime;
    
    public UndergroundSystem() {
         checkIn = new HashMap<>();
         totalTime = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIn.put(id, new CheckInInfo(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        if(totalTime.get(stationName) == null)
        {
            totalTime.put(stationName, new HashMap());
        }
        HashMap<String, StationCountInfo> map = totalTime.get(stationName);
        
        String startStation = checkIn.get(id).stationName;
        int startTime = checkIn.get(id).checkInTime;
        
        if(map.get(startStation) == null)
        {
            map.put(startStation, new StationCountInfo());
        }
        StationCountInfo cntInfo = map.get(startStation);
        cntInfo.totalTime += t - startTime;
        cntInfo.totalCount++;
    }
    
    public double getAverageTime(String startStation, String endStation) {
        StationCountInfo info = totalTime.get(endStation).get(startStation);
        return 1.0*info.totalTime / info.totalCount;
    }
    
    class CheckInInfo
    {
        public String stationName;
        public int checkInTime;
        CheckInInfo(String stationName, int checkInTime)
        {
            this.stationName = stationName;
            this.checkInTime = checkInTime;
        }
    }
    
    class StationCountInfo
    {
        public int totalTime;
        public int totalCount;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
// @lc code=end

