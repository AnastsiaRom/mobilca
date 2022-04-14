<template>
  <Page>
    <ActionBar title="вес" />
    <StackLayout verticalAlignment="top">
      <convertor :ToDefault="ToDefault" :ToNeed="ToNeed" />
    </StackLayout>
  </Page>
</template>

<script>
import Convertor from "@/components/Convertor.vue";

export default {
  data() {
    return {
      ToDefault: {
        "фунт": function (val) {
          return val;
        },
        "кг": function (val) {
          return val / 0.45359237;
        },
      },
      ToNeed: {
        "фунт": function (val) {
          return val;
        },
        "кг": function (val) {
          return val * 0.45359237;
        },
      },
    };
  },
  components: {
    Convertor,
  },
};
</script>
