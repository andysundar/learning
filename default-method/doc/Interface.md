# _default_ modifer in the interface
## Interface

An interface is an abstract type which is used to describe the behaviour of the class which implement it. In other words an interface will tell us what are the method(s) defined by the implementing class. 

## Declration of interface
An interface can also be defined inside a class or in an another interface.An interface can also extend another interface. There are some examples later in this chapter. 

### Field defined in Interface

All the fields defined in an interface is implicitly *public final static*. As a result, field value once assigned cannot be changed later. 
 
`
interface CustomerOperation {
    int STATUS = 1; 
    /*  It internally means. 
     *  public final static int STATUS = 1; 
     */
}
`
### Method defined in Interface

If *public* access specifier is used for a method then it should not have a method body.  This method should be *abstract* in nature and by default it will be *abstract* in nature. 

```
interface CustomerOperation {
    /*  It internally means. 
     *  public abstarct int currentStatus(); 
     */
    int currentStatus();
}
```

#### JDK 9 and above 
There is a change in methods declaration from JDK 9. 

*private* access specifier is allowed. **Please take a note here *private* access specifier is newly allowed from JDK 9 and above.** 

*private*, *static*, and *default* modifier method must have a body. These methods are not implicitly *abstract*.

```
interface Outer {
    /*  
    *   If you don't specify the access specifier  
    *   in the interface it is always public.
    *   In this example classSimpleName() and method() 
    *   are public implicitly. 
    */

    static String classSimpleName() {
       return  Outter.class.getSimpleName();
    }

    private String className() {
        return Outer.classSimpleName();
    }

    default String method() {
        return className();
    }

}
```
*static* method works in same ways as *static* method in classes, except that they are not inherited. 

```
interface Parent {
    
    static void create() {
        System.out.println("In parent interface");
    }
}
```
```
interface Child extends Parent  {

    static void create() {
        System.out.println("In child interface");
    }

}
```
This allows helper methods that are specific to an interface to live with the interface, rather than in a different class.
___Example taken from ***java.util.Comparator***___

```
public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
    return Collections.reverseOrder();
}
 ```   

## Default method
*default* modifer was introduced from JDK 7. It was really difficult to introduce a new method in an existing interface without breaking the exisitng implementations. More the implementations we have more problem it will be.  Lets take an example to understand it better. 

We are approached by a bank to provide a basic banking solution to XYZ Bank. They are a very small bank and they need only the basic banking operations like opening & closing an account, credit & debit the account balance, and interest calculations.  

_AccountService_ interface is the basic service provider for the XYZ Bank's services. 
```
public interface AccountService {
    AccountNumber createAccount(AccountDetail accountDetail); 
    Balance debit(AccountNumber accountNumber, BigDecimal amount);
    Balance credit(AccountNumber accountNumber, BigDecimal amount);
}
```
_BankerAccountService_ interface  specifies the extra service for the XYZ Bank's employees only.
```
public interface BankerAccountService extends AccountService {
    AccountStatus closeAccount(AccountNumber accountNumber); 
}
```
We deployed the ***first version / v.1*** of our basic banking software to XYZ Bank and they are very happy with us. 
Now aftersome time another bank named ABC Bank came to us and showed interest to implement our basic banking software and they required one more feature to our existing basic banking software. 
The new feature is issuing and closing a debit card agaist an account. Now you can see we need to add two methods in _BankerAccountService_ interface because it will be determined by the bank who gets the debit card but now the problem is XYZ Bank does not require this debit card feature. XYZ Bank is very happy with existing software and they are not ready to take any new version. 

#### Before default modifer 
If we add debit card feature to our existing _BankerAccountService_ interface then we also need to upgrade XYZ Bank to the latest software also, because implementor of _BankerAccountService_ interface need to implement the debit card feature otherwise it is going to break our existing client. 

So the best way to mitigate this challenge is to create another interface for the ABC Bank and implement their specific requirement. In coming days this approach will work but it will have lots of challenges like maintaining multipe versions which will increase the supporting cost and it will be error prone. 
This approach will work and we have to be ready to bear the support cost for this approach. 
Please take a note here that we are doing a very small change in this example. Just think of it in real term changes. It will be very challelging to implement new features to the exsiting software. 

#### After default modifer 
To ease our developer's life in JDK 8 *default* modifer was introduced. *default* modifier helps us to implement default impletation in the interface so that it does not break the existing implementation. 
