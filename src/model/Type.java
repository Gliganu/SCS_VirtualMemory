package model;

/**
 * Created by GligaBogdan on 31-Mar-16.
 */
public enum Type {

    NOT_ENOUGH_MEMORY(TypeInformation.PROBLEM),
    NOT_ENOUGH_MEMORY_SOLUTION(TypeInformation.SOLUTION),
    MEMORY_FRAGMENTATION(TypeInformation.PROBLEM),
    MEMORY_FRAGMENTATION_SOLUTION(TypeInformation.SOLUTION),
    SECURITY(TypeInformation.PROBLEM),
    SECURITY_SOLUTION(TypeInformation.SOLUTION),
    ACCESS_MEMORY_DETAIL(TypeInformation.INFO),
    PAGE_TABLE(TypeInformation.INFO);

    private TypeInformation info;

    Type(TypeInformation info){
        this.info = info;
    }

    public TypeInformation getInfo() {
        return info;
    }

    public void setInfo(TypeInformation info) {
        this.info = info;
    }


    public enum TypeInformation{
            PROBLEM,SOLUTION,INFO
    }

}
