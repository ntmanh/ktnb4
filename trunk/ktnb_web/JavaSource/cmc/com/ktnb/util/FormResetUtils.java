package cmc.com.ktnb.util;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

public class FormResetUtils {

	public static final String INDEXED_DELIM1 = "[";
	public static final String INDEXED_DELIM2 = "]";
	private static HashMap descriptorsCache = null;
	private HashMap m_indexPropers = new HashMap();
    private HashMap m_Properties = new HashMap();
	static {
		descriptorsCache = new HashMap();
	}
	  /**
	   * Ham nay lay toan bo ten cac bien duoc submit len server.
	   * @return <code>ArrayList
	   * @param request
	   * @param mapping
	   */
	public ArrayList getAllProperties(
		ActionMapping mapping,
		HttpServletRequest request) {
		ArrayList properties = new ArrayList();
		String prefix = mapping.getPrefix();
		String suffix = mapping.getSuffix();
		// Iterator of parameter names
		Enumeration names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
	  m_Properties.put(name,request.getParameterValues(name));
			String stripped = new String(name);
			if (prefix != null) {
				if (!stripped.startsWith(prefix)) {
					continue;
				}
				stripped = stripped.substring(prefix.length());
			}
			if (suffix != null) {
				if (!stripped.endsWith(suffix)) {
					continue;
				}
				stripped =
					stripped.substring(0, stripped.length() - suffix.length());
			}
			if (!properties.contains(stripped)) {
				properties.add(stripped);
			}
		}
		return properties;
	}
  /**
   * Ham nay tra ve cac ten bien la array vi du: param1[1][2].param2[3][4].param2
   * se tra ve 2 cap {(param1,([1][2])),(param1[1][2].param2,([3][4]))}. 
   * 
   * @return 
   * @param list
   */
	private HashMap getAllIndexProperties(ArrayList list) {
		if (list == null) {
			return null;
		}
		HashMap properties = new HashMap();
		for (int i = 0; i < list.size(); i++) {
			String prop = (String) list.get(i);
			String propTm = new String(prop);
			boolean isOk1 = true;
			while (isOk1) {
				int ind1 = propTm.lastIndexOf(INDEXED_DELIM2);
				if (ind1 > 0) {
					boolean isOk2 = true;
					int ind2 = propTm.lastIndexOf(INDEXED_DELIM1);
					propTm = propTm.substring(0, ind2);
					while (isOk2) {
						int ind3 = propTm.lastIndexOf(INDEXED_DELIM2);
						if (ind3 > 0) {
							if (ind2 == ind3 + 1) {
								ind2 = propTm.lastIndexOf(INDEXED_DELIM1);
								propTm = propTm.substring(0, ind2);
							} else {
								isOk2 = false;
							}
						} else {
							isOk2 = false;
						}
					}
					if (ind2 > 0) {
						String propIndex = prop.substring(0, ind2);
						String index = prop.substring(ind2, ind1  + 1);
						ArrayList listProp =
							(ArrayList) properties.get(propIndex);
						if (listProp != null) {
							listProp.add(index);
						} else {
							listProp = new ArrayList();
							listProp.add(index);
							properties.put(propIndex, listProp);
						}
					}

				} else {
					isOk1 = false;
				}
			}
		}
	return properties;
	}
  /**
   * Ham nay se xu: voi dau vao {(param1,[1][2]),(param1,[1][1])} xe tra ra ket qua la {(param1,(1,2))}
   * 
   * @return 
   * @param properties
   */
	private HashMap processCounter(HashMap properties) {
		if (properties == null) {
			return null;
		}
		Iterator iter = properties.keySet().iterator();
		HashMap ret = new HashMap();
		while (iter.hasNext()) {
			String propName = (String) iter.next();
			ArrayList listIndex = (ArrayList) properties.get(propName);
			ArrayList counter = processIndex(listIndex);
			if (counter != null) {
				ret.put(propName, counter);
			}
		}
	return ret;
	}
  /**
   * ham nay
   * @return 
   * @param listIndex
   */
	private ArrayList processIndex(ArrayList listIndex) {
		ArrayList ret = new ArrayList();
		int size = listIndex.size();
		for (int i = 0; i < size; i++) {
			String tmp = (String) listIndex.get(i);
			if (tmp != null) {
				int in = 0;
				boolean ok = true;
				while (ok) {
					int ind1 = tmp.indexOf(INDEXED_DELIM1);
					int ind2 = tmp.indexOf(INDEXED_DELIM2);
					if ((ind1 >= 0) && (ind2 > ind1 + 1)) {
						String number =
							tmp.substring(ind1 + 1, ind2);
						int num = 0;
						try {
							num = Integer.parseInt(number);
						} catch (NumberFormatException e) {
							e.printStackTrace();
						}
						if (ret.size() > in) {
							Integer num1 = (Integer) ret.get(in);
							if (num1.intValue() < num) {
								ret.set(in, new Integer(num));
							}
						} else {
							ret.add(new Integer(num));
						}
						in++;
						if (ind2 + 1 < tmp.length()) {
							tmp = tmp.substring(ind2 + 1);
						}
			else 
			{
			  tmp = "";
			}
					} else {
						ok = false;
					}
				}
			}
		}
		return ret;
	}

  /**
   * get properties bang reflection cua java
   * @return 
   * @param beanClass
   */
	public PropertyDescriptor[] getPropertyDescriptors(Class beanClass) {

	if (beanClass == null) {
	  return new PropertyDescriptor[0];
	}

	// Look up any cached descriptors for this bean class
	PropertyDescriptor descriptors[] = null;
	descriptors = (PropertyDescriptor[]) descriptorsCache.get(beanClass);
	if (descriptors != null) {
	  return (descriptors);
	}

	// Introspect the bean and cache the generated descriptors
	BeanInfo beanInfo = null;
	try {
	  beanInfo = Introspector.getBeanInfo(beanClass);
	} catch (IntrospectionException e) {
	  return (new PropertyDescriptor[0]);
	}
	descriptors = beanInfo.getPropertyDescriptors();
	if (descriptors == null) {
	  descriptors = new PropertyDescriptor[0];
	}
	descriptorsCache.put(beanClass, descriptors);
		return (descriptors);
	}
  /**
   * 
   * @throws java.lang.Exception
   * @return 
   * @param name
   * @param list
   * @param size
   * @param i
   * @param clazz
   */
	private Object createArray(Class clazz, int i, int size, ArrayList list,String name,String prefix)
		throws Exception {
		if (i == size) {
			Object obj = createNewInstance(clazz,prefix);
	  if(obj != null) {
		createObject(obj,name,prefix);
	  }
	  //Start Doan nay them vao de tu populate
//		else 
//		{
//			if(obj == null) 
//			{
//			  String valueTmp[] =(String[]) m_Properties.get(name);
//			  if((valueTmp != null)&&(valueTmp.length > 0))
//			  {
//				obj = valueTmp[0];
//			  }
//			}
//		}
	  //Finish Doan nay them vao de tu populate
			return obj;
		} 
	else {
			int size1 = ((Integer) list.get(i)).intValue();
			Object retval = Array.newInstance(clazz.getComponentType(), size1+1);
			for (int k = 0; k < size1+1; k++) {
				String name1 = name+"[" + k + "]";
				Array.set(retval,k,createArray(clazz.getComponentType(), i + 1, size, list,name1,prefix));
			}
			return retval;
		}
	}
  /**
   * 
   * @throws java.lang.Exception
   * @return 
   * @param prefix
   * @param clazz
   */
  private Object createNewInstance(Class clazz, String prefix) throws Exception
  {
	if (clazz!=null && (!(clazz.isPrimitive() || (clazz.equals(String.class))))) 
	{
	  if(prefix == null) 
	  {
		return clazz.newInstance();
	  }
	  else 
	  {
		String nameOfClass = clazz.getName();  
		if(nameOfClass.indexOf(prefix) == 0) 
		{
		  return clazz.newInstance();
		}
		else 
		{
		  if(clazz.equals(String[].class)) 
		  {
			return clazz.newInstance();
		  } 
		  else 
		  {
			return null;  
		  }
          
		}
	  }
	}
	else 
	{
	  return null;
	}

  }
  /**
   * Tao object
   * @param name
   * @param bean
   */
	private void createObject(Object bean, String name,String prefix) {

		if ((bean == null) || (m_indexPropers.size() == 0)) {
			return;
		}
  try {
	PropertyDescriptor[] descriptor =
	  getPropertyDescriptors(bean.getClass());
	for (int i = 0; i < descriptor.length; i++) {
	   try {
		  Object obj = null;
		  String propName = descriptor[i].getName();
		  String name1 = name;
		  if (!name1.equals("")) {
			name1 = name1 + "." + propName;
		  } 
		  else {
			name1 = propName;
		  }
		  Class clazzArr = descriptor[i].getPropertyType();
		  if (clazzArr!=null && clazzArr.isArray()) {
			ArrayList list = (ArrayList) m_indexPropers.get(name1);
			if(list!=null) {
				obj = createArray(clazzArr, 0, list.size(), list,name1,prefix);
//				System.out.println("-----------"+name1+":" + list.size());
			}
		  } 
		  else {
			  obj = this.createNewInstance(clazzArr,prefix);
			  if(obj != null) {
				createObject(obj, name1,prefix);
			  }
		  } 
		  //@Cam xoaStart Doan nay them vao de tu populate
//			if(obj == null) 
//			{
//			  String valueTmp[] =(String[]) m_Properties.get(name1);
//			  if((valueTmp != null)&&(valueTmp.length > 0))
//			  {
//				obj = valueTmp[0];
//			  }
//			}
		  //Finish Doan nay them vao de tu populate
		  if(obj != null) {
			Method writeMethod = descriptor[i].getWriteMethod();
			Object beanPara[] = { obj };
			writeMethod.invoke(bean, beanPara);
		  }
	  }
	  catch(Exception e) 
	  {
	   e.printStackTrace();
	  }
	}
  } 
  catch (Exception e) {
	e.printStackTrace();
  }
	}
	public void resetForm(Object bean,ActionMapping mapping,HttpServletRequest resquest) {
		try {
			ArrayList properties = this.getAllProperties(mapping,resquest);
			HashMap indexProperties = this.getAllIndexProperties(properties);
			m_indexPropers = this.processCounter(indexProperties);
			createObject(bean,"",null);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void resetForm(Object bean,ActionMapping mapping,HttpServletRequest resquest,String prefix) {
		try {
			ArrayList properties = this.getAllProperties(mapping,resquest);
			HashMap indexProperties = this.getAllIndexProperties(properties);
			m_indexPropers = this.processCounter(indexProperties);
			createObject(bean,"",prefix);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
  
}