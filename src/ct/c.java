package ct;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class c
{
  public static final int[] a = { 80, 8080, 14000 };
  public long b;
  private Map c;
  
  public c() {}
  
  public c(aj paramaj)
  {
    b = b;
    c = new HashMap();
    Iterator localIterator = a.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (ay.a(localInteger))
      {
        Object localObject = (ArrayList)a.get(localInteger);
        ArrayList localArrayList = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          s locals = new s();
          if (locals.a(str)) {
            localArrayList.add(locals);
          }
        }
        c.put(localInteger, localArrayList);
      }
    }
  }
  
  private static String a(int paramInt)
  {
    String str = "";
    if (paramInt == 1) {
      str = "access_cm";
    }
    do
    {
      return str;
      if (paramInt == 2) {
        return "access_uni";
      }
    } while (paramInt != 3);
    return "access_ct";
  }
  
  public final void a()
  {
    SharedPreferences localSharedPreferences = p.a().getSharedPreferences("Access_Preferences", 0);
    b = localSharedPreferences.getLong("timeStamp", 0L);
    c = new HashMap();
    int i = 1;
    while (i <= 3)
    {
      Object localObject2 = localSharedPreferences.getString(a(i), "");
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = "";
        if (i != 1) {
          break label161;
        }
        localObject1 = "183.61.38.168:14000,117.135.171.182:14000";
      }
      for (;;)
      {
        az.b();
        localObject1 = ((String)localObject1).split(",");
        if (localObject1.length <= 0) {
          break label201;
        }
        localObject2 = new ArrayList();
        int k = localObject1.length;
        int j = 0;
        while (j < k)
        {
          String str = localObject1[j];
          s locals = new s();
          if (locals.a(str)) {
            ((ArrayList)localObject2).add(locals);
          }
          j += 1;
        }
        label161:
        if (i == 2) {
          localObject1 = "112.90.140.213:14000,112.90.140.216:14000";
        } else if (i == 3) {
          localObject1 = "14.17.41.159:14000,140.206.160.242:14000";
        }
      }
      c.put(Integer.valueOf(i), localObject2);
      label201:
      i += 1;
    }
  }
  
  public final void b()
  {
    SharedPreferences localSharedPreferences = p.a().getSharedPreferences("Access_Preferences", 0);
    if ((c != null) && (c.size() > 0))
    {
      Iterator localIterator = c.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (Integer)localIterator.next();
        if (ay.a((Integer)localObject1))
        {
          String str = a(((Integer)localObject1).intValue());
          Object localObject2 = (ArrayList)c.get(localObject1);
          if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
          {
            localObject2 = new StringBuilder();
            localObject1 = ((ArrayList)c.get(localObject1)).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              ((StringBuilder)localObject2).append(((s)((Iterator)localObject1).next()).a());
              ((StringBuilder)localObject2).append(",");
            }
            ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
            localSharedPreferences.edit().putString(str, ((StringBuilder)localObject2).toString()).commit();
          }
        }
      }
      localSharedPreferences.edit().putLong("timesStamp", b).commit();
    }
  }
  
  public final ArrayList c()
  {
    int k = 0;
    int i = ay.d();
    ArrayList localArrayList1 = new ArrayList();
    Object localObject;
    if (ay.a(Integer.valueOf(i)))
    {
      localIterator = c.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (Integer)localIterator.next();
        ArrayList localArrayList2 = (ArrayList)c.get(localObject);
        if (i == ((Integer)localObject).intValue()) {
          localArrayList1.addAll(0, localArrayList2);
        } else {
          localArrayList1.addAll(localArrayList2);
        }
      }
    }
    Iterator localIterator = c.keySet().iterator();
    int j;
    for (i = 0;; i = Math.max(i, ((ArrayList)c.get(localObject)).size()))
    {
      j = k;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (Integer)localIterator.next();
    }
    for (;;)
    {
      j += 1;
      if (j >= i) {
        break;
      }
      localIterator = c.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (Integer)localIterator.next();
        localObject = (ArrayList)c.get(localObject);
        if (j < ((ArrayList)localObject).size()) {
          localArrayList1.add(((ArrayList)localObject).get(j));
        }
      }
    }
    return localArrayList1;
  }
}

/* Location:
 * Qualified Name:     ct.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */