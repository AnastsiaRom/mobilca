<template>
  <Page class="page">
    <ActionBar title="Задачи" />
    <TabView
      height="100%"
      textFieldBackgroundColor="#07bb58"
      android-tabs-position="bottom"
      tab-text-font-size="16"
    >
      <TabViewItem title="Текущие">
        <StackLayout orientation="vertical">
          <GridLayout columns="2*,*" rows="*" width="100%" height="25%">
            <TextField
              v-model="newTask"
              col="0"
              row="0"
              hint="Новая задача"
              @returnPress="onButtonTap"
            />
            <Button
              id="butt-append"
              col="1"
              row="0"
              text="Добавить"
              @tap="onButtonTap"
            />
          </GridLayout>
          <ListView
            class="list-group"
            for="todo in todos"
            separator-color="transparent"
          >
            <v-template>
              <GridLayout columns="*3,2*" rows="2*,*" width="100%" height="25%">
                <Label
                  col="0"
                  id="active-task"
                  :text="todo.name"
                  class="list-group-item-heading"
                  text-wrap="true"
                />
                <StackLayout col="1">
                  <Button
                    id="button-close"
                    col="1"
                    row="1"
                    text="закрыть"
                    @tap="closeToDo(todo)"
                  />
                  <Button
                    id="button-remove"
                    col="1"
                    row="2"
                    text="удалить"
                    @tap="deleteToDo(todo)"
                  />
                </StackLayout>
              </GridLayout>
            </v-template>
          </ListView>
        </StackLayout>
      </TabViewItem>

      <TabViewItem title="Завершенные" text-transform="uppercase">
        <ListView
          class="list-group"
          for="done in dones"
          style="height: 75%"
          separator-color="transparent"
        >
          <v-template>
            <GridLayout columns="*3,2*" rows="2*,*" width="100%" height="25%">
              <Label
                id="completed-task"
                :text="done.name"
                class="list-group-item-heading"
                text-wrap="true"
              />
              <StackLayout col="1">
                <Button
                  id="button-return"
                  col="1"
                  row="1"
                  text="вернуть"
                  @tap="returnDoneToDo(done)"
                />
                <Button
                  id="button-remove"
                  col="1"
                  row="2"
                  text="удалить"
                  @tap="deleteDoneToDo(done)"
                />
              </StackLayout>
            </GridLayout>
          </v-template>
        </ListView>
      </TabViewItem>
    </TabView>
  </Page>
</template>

<script>
import { getTasks, setTask } from "@/storage.js";

export default {
  data() {
    return {
      dones: [],
      todos: [],
      newTask: "",
    };
  },
  created() {
    this.todos = getTasks("todos");
    this.dones = getTasks("dones");
  },
  methods: {
    closeToDo(args) {
      this.dones.unshift(args);
      this.todos = this.todos.filter((val) => val["name"] !== args.name);
      this.setValues();
    },
    deleteToDo(args) {
      this.todos = this.todos.filter((val) => val["name"] !== args.name);
      this.setValues();
    },
    returnDoneToDo(args) {
      this.todos.unshift(args);
      this.dones = this.dones.filter((val) => val["name"] !== args.name);
      this.setValues();
    },
    deleteDoneToDo(args) {
      this.dones = this.dones.filter((val) => val["name"] !== args.name);
      this.setValues();
    },
    setValues() {
      setTask("todos", this.todos);
      setTask("dones", this.dones);
    },
    onButtonTap() {
      if (!this.newTask) return;

      this.todos.unshift({
        name: this.newTask,
      });

      setTask("todos", this.todos);

      this.newTask = "";
    },
  },
};
</script>

<style scoped>
TextField {
  font-size: 20;
  color: #0426e2;
  margin-top: 10;
  margin-bottom: 10;
  margin-right: 5;
  margin-left: 20;
  height: 60;
}
#butt-append {
  font-size: 12;
  font-weight: bold;
  color: white;
  background-color: #1a2c95;
  padding: 10;
  border-radius: 20px;
}
#button-close {
  font-size: 12;
  font-weight: bold;
  color: white;
  background-color: #07bb58;
  padding: 10;
}
#button-remove {
  font-size: 12;
  font-weight: bold;
  color: white;
  background-color: #c71515;
  padding: 10;
}
#button-return {
  font-size: 12;
  font-weight: bold;
  color: white;
  background-color: #acd51a;
  padding: 10;
}
#active-task {
  font-size: 20;
  font-weight: bold;
  color: #2f2e2e;
  margin-left: 20;
  padding-top: 5;
  padding-bottom: 10;

}
#completed-task {
  font-size: 20;
  color: #494545;
  margin-left: 20;
  padding-top: 5;
  padding-bottom: 10;
}
</style>