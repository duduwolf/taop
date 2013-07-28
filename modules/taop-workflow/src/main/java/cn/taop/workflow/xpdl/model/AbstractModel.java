package cn.taop.workflow.xpdl.model;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 流程模型元素抽象类,一些公用属性和方法全部在这里实现，子类全部继承此抽象类
 * 
 * @author duduwolf
 */
public abstract class AbstractModel implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 流程物理ID
	 */
	protected String id = null;
	
	/**
	 * 流程名称
	 */
	protected String name = null;
	
	/**
	 * 流程描述
	 */
	protected String description = null;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof Serializable && obj instanceof AbstractModel) {
			try {
				result = this.getId().equals(((AbstractModel)obj).getId());
			} catch (Exception e) {
				log.error("对传入的对象进行equals比较时出错：" + e.getMessage());
			}
		}
		
		return result;
	}
	
	@Override
	public int hashCode() {
		return this.getId().hashCode();
	}
	
	@Override
	public String toString() {
		return this.getName();
	}
	
	static final Logger log = LoggerFactory.getLogger(AbstractModel.class);
}
