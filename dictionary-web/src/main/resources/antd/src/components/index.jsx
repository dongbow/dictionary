import React,{Component} from 'react';
import connectToStores from 'alt-utils/lib/connectToStores';
import IndexStore from 'stores/IndexStore.js';
import {Tabs, Icon} from 'antd';
import Layout from 'components/common/Layout';
import dict from 'components/dict';
import trans from 'components/trans';

const TabPane = Tabs.TabPane;

class index extends Component {

  static getStores(){
    return [IndexStore]
  }

  static getPropsFromStores(){
    let state = IndexStore.getState();
    return {
      dictionary : state.dictionary,
      translate: state.translate
    }
  }

  render(){
    return(
      <Layout>
        <Tabs defaultActiveKey="1">
          <TabPane tab={<span><Icon type="book" />词典</span>} key="1">
            <div><dict/></div>
          </TabPane>
          <TabPane tab={<span><Icon type="global" />翻译</span>} key="2">
            <div><trans/></div>
          </TabPane>
        </Tabs>
      </Layout>
    )
  }
}

export default connectToStores(index);
