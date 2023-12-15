package newjavaprograms;

public class StringPool {
    static char[] pool = new char[1024];
    static int[] free = new int[1024];

    static int put(char[] value){
        int firstIndex = 0;
        int lastIndex=0;

        if(checkFree(value.length) < 55555){
            firstIndex = checkFree(value.length);
//            System.out.println("first" + firstIndex);
        }else{
            //finding empty index in char array
            while(pool[firstIndex] != '\0'){
                ++firstIndex;
            }
        }
        //appending value and finding last index
        for( int i=firstIndex; i<value.length+firstIndex; i++){
            pool[i] = value[ i - firstIndex ];
            lastIndex=i;
        }
        //to generate first reference for first data addition
        if(firstIndex == 0){
            return lastIndex*10000;
        }
        int reference = generateReference(firstIndex, lastIndex);
        removeFromFree(reference);
        return reference;
    }

    static int checkFree(int valueLength){
        for(int i=0; i<free.length; i++){
            if(free[i] > 0){
                if(valueLength == getLastIndex(free[i]) - getFirstIndex(free[i]) + 1){
                    return getFirstIndex(free[i]);
                }else if(valueLength < (getLastIndex(free[i]) - getFirstIndex(free[i])) + 1){
                    int firstIndex = getFirstIndex(free[i]);
                    free[i] = generateReference(getFirstIndex(free[i]) + valueLength, getLastIndex(free[i]));
                    System.out.println("first"+valueLength);
                    return firstIndex;
                }
            }
        }
        System.out.println("second" + valueLength);
        return 55555;
    }

    static void putToFree(int reference){
        for(int i : free){
            if(free[i] == 0){
                free[i] = reference;
                break;
            }
        }
    }

    static void removeFromFree(int reference){
        for(int i : free){
            if(free[i] == reference){
                free[i] = 0;
            }
        }
    }

    static int generateReference(int firstIndex, int lastIndex){
        int reverse=0;
        //firstIndex is reversed and additional 0's are added to make 4 digit
        //lastIndex and result are concatinated
        for(int i=0; i<4; i++){
            int lastNumber = firstIndex % 10;
            firstIndex /= 10;
            reverse = reverse * 10 + lastNumber;
        }
        return lastIndex*10000+reverse;
    }

    static char[] get(int index){
        int firstIndex = getFirstIndex(index);
        int lastIndex = getLastIndex(index);
        int length = lastIndex - firstIndex + 1;
        char[] name = new char[length];

        for(int i=0; i<free.length; i++){
            if(free[i] == index){
                return "This String has been deleted.".toCharArray();
            }
        }

        for(int i=0; i<length; i++){
            name[i] = pool[firstIndex+i];
        }
        return name;
    }

    static int getFirstIndex(int number){
        int reverse = 0;
        //get last 4 digit of number
        for(int i=0; i<4; i++){
            int lastNumber = number % 10;
            number /= 10;
            reverse = reverse * 10 + lastNumber;
        }
        return reverse;
    }

    static int getLastIndex(int number){
        //get number excluding last 4 digit
        return number/10000;
    }


    public static void main(String[] args) {
        int thisReference = StringPool.put("This".toCharArray());
        int whoseReference = StringPool.put("Whose".toCharArray());
        int bottleReference = StringPool.put("Bottle".toCharArray());

        System.out.println(new String().valueOf(get(thisReference)));
        System.out.println(new String().valueOf(get(whoseReference)));
        System.out.println(new String().valueOf(get(bottleReference)));
        System.out.println("String pool: " + new String().valueOf(pool));

        System.out.println("Removing whose");
        System.out.println(whoseReference);
        putToFree(whoseReference);
        System.out.println(new String().valueOf(get(whoseReference)));
        System.out.println("String pool: " + new String().valueOf(pool));

        int howReference = StringPool.put("How".toCharArray());
        System.out.println("Added How");
        System.out.println(new String().valueOf(get(howReference)));
        System.out.println("String pool: " + new String().valueOf(pool));
    }
}
