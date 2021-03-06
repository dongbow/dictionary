import React,{Component} from 'react';
import connectToStores from 'alt-utils/lib/connectToStores';
import IndexAction from 'actions/IndexAction.js';
import IndexStore from 'stores/IndexStore.js';
import {Input, Select} from 'antd';

const InputGroup = Input.Group;
const Option = Select.Option;

class dict extends Component {

  static getStores(){
    return [IndexStore]
  }

  static getPropsFromStores(){
    let state = IndexStore.getState();
    return {
      dictionary : state.dictionary
    }
  }

  render(){
    return(
      <div>
        <span>词典</span>
        {this.props.dictionary}
      </div>
    )
  }
}

export default connectToStores(dict);
