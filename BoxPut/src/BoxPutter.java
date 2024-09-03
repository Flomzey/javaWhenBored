import java.util.ArrayList;
import java.util.List;

public class BoxPutter{
    
    public enum Item{
        DIAMOND (1, 5),
        GOlDBAR (2, 11),
        RING(3,18),
        CROWN (5, 40),
        SCALE (10, 90);


        @Override
        public String toString(){
            String str = switch(this){
                case DIAMOND -> "Diamond";
                case GOlDBAR -> "Goldbar";
                case RING -> "Ring";
                case CROWN -> "Crown";
                case SCALE -> "Scale";
                default -> "";
            };

            return str;
        }


        private final int size;
        private final int value;
        Item(int size, int value){
            this.size = size;
            this.value = value;  
        }

        int size() {return size;}
        int value() {return value;}
    }


    public void putBox(int boxSize){
        List<Item[]> boxList = new ArrayList<>(); 
        for(int i = 0; i <= boxSize; i++){
            boxList.add(i, new Item[i]);
        }
        for (Item[] items : boxList) {
            for (int i = 0; i < items.length; i++) {
                items[i] = Item.values()[0];
            }
        }
        
        for (int i = 1; i < Item.values().length; i++) {
            Item currenItem = Item.values()[i];
            for (Item[] iteratingBox : boxList) {
                Integer curValue = boxVolume(iteratingBox) + Item.values()[i].value;
                Integer toBeSize = iteratingBox.length + currenItem.size;

                if(toBeSize > boxSize) break;

                Item[] switchBox = boxList.get(toBeSize);

                if(boxVolume(switchBox) < curValue){
                    for (int j = 0; j < iteratingBox.length; j++) {
                        switchBox[j] = iteratingBox[j];
                    }
                    for (int j = switchBox.length-1; j >= (switchBox.length - currenItem.size); j--) {
                        switchBox[j] = currenItem;
                    }
                    boxList.set(toBeSize, switchBox);
                }
            }
            System.out.println(itemListToString(boxList));
        }

        
    }

    public String itemListToString(List<Item[]> itemList){
        String returnString = "";
        for (Item[] items : itemList) {
            returnString += boxVolume(items) + " [";
            for (int i = 0; i < items.length; i++) {
                returnString += items[i].toString() + ",";
            }
            returnString += "]\n";
        }
        return returnString;
    }

    public Integer boxVolume(Item[] box){
        Integer returnInt = 0;
        for (Item item : box) {
            returnInt += item.value/item.size;
        }
        return returnInt;
    }
}