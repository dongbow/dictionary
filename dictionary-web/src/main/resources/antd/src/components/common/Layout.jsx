import React,{ Component } from 'react';
import { Link } from 'react-router';
import { Menu, Icon, Spin, Row, Col } from 'antd';

const SubMenu = Menu.SubMenu;
const MenuItemGroup = Menu.ItemGroup;

class Layout extends Component {
	render(){
		return (
			<div>
				<div>
					{this.props.children}
				</div>
			</div>
		);
	}
}

export default Layout;
