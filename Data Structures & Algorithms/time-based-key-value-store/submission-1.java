class TimeMap {

    public Map<String,List<Pair<Integer,String>>> tmap;
    public TimeMap() {
        tmap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {

        List<Pair<Integer,String>> list;
        if(this.tmap.get(key) == null){
            list = new ArrayList<>();
        }else{
            list = this.tmap.get(key);
        }

        list.add(new Pair<Integer,String>(timestamp,value));
        this.tmap.put(key,list);
    }
    
    public String get(String key, int timestamp) {
        if(this.tmap.get(key) == null){
            return "";
        }

        List<Pair<Integer,String>> list = this.tmap.get(key);

        int begin =0;
        int end = list.size()-1;
        String res = "";
        while(begin<=end){
            int mid = (begin+end)/2;
            if(list.get(mid).getKey()>timestamp){
                end = mid - 1;
            }else{
                res = list.get(mid).getValue();
                begin = mid + 1;
            }
        }
        return res;
    }
}
